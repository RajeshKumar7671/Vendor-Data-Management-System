package com.app.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Location;
import com.app.services.ILocationService;
import com.app.util.LocationUtil;
import com.app.validator.LocationValidator;

@Controller
public class LocationController {
	@Autowired
	private ILocationService service;
	@Autowired
	private ServletContext context;
	@Autowired
	private LocationUtil util;
	@Autowired
	private LocationValidator validator;
	
	@RequestMapping("/regLoc")
	public String showLocationRegPage(){
		return "LocationReg";
	}
	@RequestMapping("/locData")
	public String showLocationDataPage(){
		return "LocationData";
	}
	
	@RequestMapping(value="/insertLoc",method=RequestMethod.POST)
	public String saveLocData(@ModelAttribute("location")Location loc,ModelMap map){
		//check data with validator 
				String locRegMsg=validator.doValidateLocName(loc.getLocName());
				if(locRegMsg!=null){
					//data has error
					map.addAttribute("locRegMsg",locRegMsg);
				}else{
					//save data-no error
					int id=service.saveLocation(loc);
					map.addAttribute("locRegMsg", "Your Location ID:"+id);
				}
		return "LocationReg";
	}
	
	@RequestMapping("/viewAllLoc")
	public String showAllLocation(ModelMap map){
		//read data from SL
		List<Location> locList=service.getAllLocations();
		//send to UI 
		map.addAttribute("locListObj", locList);
		//specify UI page name
		return  "LocationData";
	}
	
	@RequestMapping("/updateLoc")
	public String showEditPage(@RequestParam("LocId")int locId,ModelMap map){
		
		Location loc=service.getLocationById(locId);
		map.addAttribute("locObj",loc);
		
		return "LocationUpdate";
	}
	
	@RequestMapping(value="/locUpdate",method=RequestMethod.POST)
	public String updateLocationData(@ModelAttribute("location")Location loc, ModelMap map){
		//check data with validator 
		String msg=validator.doValidateLocName(loc.getLocName());
		if(msg!=null){
			//data has error
			map.addAttribute("msg",msg);
		}else{
			//save data-no error
			service.updateLoc(loc);	
		}
		return "redirect:viewAllLoc";
	}
	

	@RequestMapping("deleteLoc")
	public String deleteLoc(@RequestParam("LocId")int id)
	{
		service.deleteLocById(id);
		return "redirect:viewAllLoc";
	}
	
	
	@RequestMapping("/locRep")
	public String generateCharts(){
		List<Object[]> list=service.getLocationwiseCount();
		String path=context.getRealPath("/");
		
		util.generatePiechart(path, list);
		util.generateBarchart(path, list);
		return "LocReport";
	}
	
}
