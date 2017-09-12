package com.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Consumer;
import com.app.services.IConsumerService;
@Controller
public class ConsumerController {
  
	@Autowired
	private IConsumerService service;
	/**
	 * This method is used to
	 * fetch all records from DB
	 * using SL and sends to UI
	 * using ModelMap , it is executed
	 * when 'viewAllCons' req is made
	 * It can be called from InsertCons Page
	 */
	//provide url
	@RequestMapping("/viewAllCons")
	public String showAllConsumer(ModelMap map){
		//read data from SL
		List<Consumer> consList=service.getAllConsumer();
		//send to UI 
		map.addAttribute("consListObj", consList);
		//specify UI page name
		return  "ConsumerData";
	}
	
	
	@RequestMapping("/consDetails")
	public String showConsumerDetailsPage(@RequestParam("consId")int consId,ModelMap map)
	 {
	   Consumer cons=service.getConsumerById(consId);
	   map.addAttribute("consObject",cons);
	   return "ConsumerDetails";
     }
	
	@RequestMapping("/updateCons")
	public String showEditPage(@RequestParam("consId")int consId,ModelMap map){
	
		Consumer cons=service.getConsumerById(consId);
		map.addAttribute("consObj",cons);
		return "ConsumerUpdate";
	}
	
	/**
	 * this method is used to
	 * get obj from UI form
	 * and sends to service layer
	 * and redirect to Show Page.
	 * THis is type POST.
	 */
	@RequestMapping(value="/consUpdate",method=RequestMethod.POST)
	public String updateConsData(@ModelAttribute("Consumer")Consumer cons){
		service.updateCons(cons);
		return "redirect:viewAllCons";
	}
	
	/**
	 * This method is used to delete
	 * data from database
	 * and sending all in UI page
	 */
	@RequestMapping("deleteCons")
	public String deleteCons(@RequestParam("consId")int id)
	{
		service.deleteConsById(id);
		return "redirect:viewAllCons";
	}
	
	
	/**
	 * Login process
	 */
	@RequestMapping(value="/loginCons",method=RequestMethod.POST)
	public String doLoginConsumer(
			@RequestParam("consId")String consEmail,
			@RequestParam("password")String pwd,
			HttpServletRequest req,ModelMap map){
	
		String pageName=null;
		Consumer cons=service.getConsumerByUmailAndPwd(consEmail, pwd);
		if(cons!=null){
			//create session and goto home page
			HttpSession ses=req.getSession();
			ses.setAttribute("consFirstName", cons.getConsFirstName());
			pageName="ConsumerAccount";
		}else{
			//create error msg and goto login page
			map.addAttribute("msg", "Worng username or password!");
			pageName="ConsumerLogin";
		}
		
	 return pageName;	
	}
	
	/**
	 * Logout process
	 */
	@RequestMapping("/consLogout")
	public String doLogout(HttpServletRequest req,ModelMap map){
		//read current session of user
		HttpSession ses=req.getSession(false);
		ses.setAttribute("consFirstName", null);
		ses.invalidate();
		map.addAttribute("msg", "Logout success...");
		return "priyakart";
	}
}
