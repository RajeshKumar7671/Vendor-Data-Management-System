package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VDMController {

	@RequestMapping("/vdmHome")
	public String showAdminVDMHomePage(ModelMap map)
	 {
		return "VdmHome";
	 }
	@RequestMapping("/home")
	public String showHomeVDMPage(ModelMap map)
	 {
		return "HomePage";
	 }
	@RequestMapping("/learning")
	public String showLearningVDMPage(ModelMap map)
	 {
		return "Learning";
	 }
	@RequestMapping("/faq")
	public String showFaqVDMPage(ModelMap map)
	 {
		return "Faq";
	 }
	
	public String venRegInMonthly()
	{
	 return null;	
	}
	public String venRegInWeekly()
	{
	 return null;	
	}
	public String venRegInToday()
	{
	 return null;	
	}
	public String venRegInYesterday()
	{
	 return null;	
	}
	
	
	
}

