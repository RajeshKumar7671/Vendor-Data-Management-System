package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.services.IItemServices;

@Controller
public class ItemController {
	@Autowired
	private IItemServices service;
	
	@RequestMapping("/showAllItem")
	public String showAllItem(ModelMap map){
		//read data from SL
		List<Item> itemList=service.getAllItem();
		System.out.print(itemList);
		//send to UI 
		map.addAttribute("itemListObj", itemList);
		//specify UI page name
		return  "ItemAllData";
	}

	@RequestMapping("/showAllPendingItem")
	public String showAllPendingItem(ModelMap map){
		//read data from SL
		List<Item> itemList=service.getAllItem();
		System.out.print(itemList);
		//send to UI 
		map.addAttribute("itemListObj", itemList);
		//specify UI page name
		return  "ItemPending";
	}
	
	@RequestMapping("/showAllApprovalItem")
	public String showAllApprovalItem(ModelMap map){
		//read data from SL
		List<Item> itemList=service.getAllItem();
		//send to UI 
		map.addAttribute("itemListObj", itemList);
		//specify UI page name
		return  "ItemApproved";
	}
	
	@RequestMapping("/showAllRejectItem")
	public String showAllRejectItem(ModelMap map){
		//read data from SL
		List<Item> itemList=service.getAllItem();
		//send to UI 
		map.addAttribute("itemListObj", itemList);
		//specify UI page name
		return  "ItemReject";
	}
	
	@RequestMapping(value="/itemApproved")
	public String itemApproved(
	  @RequestParam("itemId")int itemId,ModelMap map){
		Item itemObj=service.getItemById(itemId);
		     itemObj.setStatus("Approved");
		service.updateItem(itemObj);
		return "redirect:showAllPendingItem";
	}
	@RequestMapping(value="/itemReject")
	public String itemReject(
	  @RequestParam("itemId")int itemId,ModelMap map){
		Item itemObj=service.getItemById(itemId);
		     itemObj.setStatus("Reject");
		service.updateItem(itemObj);
		return "redirect:showAllPendingItem";
	}

	@RequestMapping("/showItemUpdate")
	public String showItemUpdateBeforeApproved(@RequestParam("itemId")int itemId,ModelMap map){
		Item item=service.getItemById(itemId);
		map.addAttribute("itemObj",item);
		return "ItemUpdate";
	}
	
	@RequestMapping(value="/itemUpdate",method=RequestMethod.POST)
	public String updateItemBeforeApproved(
	  @ModelAttribute("item")Item item,
	  @RequestParam("itemId")int itemId,ModelMap map){
		String itemDesc=item.getDetails();
		Item itemObj=service.getItemById(itemId);
		     itemObj.setDetails(itemDesc);
		service.updateItem(itemObj);
		itemObj=service.getItemById(itemId);
		map.addAttribute("itemObj",itemObj);
		return "ItemUpdate";
	}
	
	@RequestMapping("deletePendingItem")
	public String deletePendingItem(@RequestParam("itemId")int itemId)
	{
		service.deleteItemById(itemId);
		return "redirect:showAllItem";
	}
	@RequestMapping("deleteRejectItem")
	public String deleteRejectItem(@RequestParam("itemId")int itemId)
	{
		service.deleteItemById(itemId);
		return "redirect:showAllItem";
	}
	@RequestMapping("deleteItemByAdmin")
	public String deleteItemByAdmin(@RequestParam("itemId")int itemId)
	{
		service.deleteItemById(itemId);
		return "redirect:showAllItem";
	}

}
