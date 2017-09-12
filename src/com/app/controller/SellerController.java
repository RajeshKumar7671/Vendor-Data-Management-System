package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Seller;
import com.app.services.ISellerService;

@Controller
public class SellerController {
	    @Autowired
		private ISellerService service;
	
		/**
		 * This method is used to
		 * fetch all records from DB
		 * using SL and sends to UI
		 * using ModelMap , it is executed
		 * when 'viewAllseller' req is made
		 * It can be called from InsertSeller Page
		 */
		//provide url
		@RequestMapping("/viewAllSeller")
		public String showAllSeller(ModelMap map){
			//read data from SL
			List<Seller> sellerList=service.getAllSeller();
			//send to UI 
			map.addAttribute("sellerListObj", sellerList);
			//specify UI page name
			return  "SellerData";
		}
		
		
		@RequestMapping("/updateSeller")
		public String showEditPage(@RequestParam("sellerId")int sellerId,ModelMap map){
		
			Seller seller=service.getSellerById(sellerId);
			map.addAttribute("sellerObj",seller);
			return "SellerUpdate";
		}
		
		/**
		 * this method is used to
		 * get obj from UI form
		 * and sends to service layer
		 * and redirect to Show Page.
		 * THis is type POST.
		 */
		@RequestMapping(value="/sellerUpdate",method=RequestMethod.POST)
		public String updateSellerData(@ModelAttribute("Seller")Seller seller){
			service.updateSeller(seller);
			return "redirect:viewAllseller";
		}
		
		/**
		 * This method is used to delete
		 * data from database
		 * and sending all in UI page
		 */
		@RequestMapping("deleteSeller")
		public String deleteSeller(@RequestParam("sellerId")int id)
		{
			service.deleteSellerById(id);
			return "redirect:viewAllSeller";
		}
		
		@RequestMapping("/showSeller")
		public String showSellerPage(@RequestParam("sellerId")int sellerId,ModelMap map){
			
			Seller sellerObj=service.getSellerById(sellerId);
			map.addAttribute("sellerObj",sellerObj);
			return "SellerDetails";
		}
		
		
	}
