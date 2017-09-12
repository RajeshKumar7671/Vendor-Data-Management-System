package com.app.integration;

import java.util.List;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Item;
import com.app.model.ItemOrder;
import com.app.model.Seller;
import com.app.services.IItemOrderService;
import com.app.services.IItemServices;
import com.app.services.ISellerService;
import com.app.util.JsonUtil;

@Path("/itemService")
@Component
public class ItemServiceProvider {
	@Autowired
	private ISellerService sellerService;
	@Autowired
	private IItemOrderService itemOrderService;
	@Autowired
	private JsonUtil jsonUtil;
	@Autowired
	private IItemServices itemService;
	
	@POST
	@Path("/saveItem")
	public String saveItem(
			@HeaderParam("user")String un,
			@HeaderParam("password")String pwd,
			@HeaderParam("token")String token,
			String json){

		//user name should not be empty or null
		if(un==null || "".equals(un.trim()))
			return "Empty/Invalid user name!!";
		//get Seller obj/null from DB using user name/email Id
		Seller seller=sellerService.getSellerObByEmailId(un);
		if(seller==null)
			return "Username is invalid";
		//validate given Seller object for save opr.
		//with pwd and token data
		String dbPwd=seller.getPwd();
		String dbToken=seller.getToken();
		if(!dbPwd.equals(pwd) && dbToken.equals(token)){
		   return "Invalid Authentication details(pwd,token)/Invalid seller type for operation";
		}
		Item ob=(Item)jsonUtil.convertJsonToObj(json, Item.class);
		if(ob==null)
			return "No item details found";
		//set sellerId and save item
		ob.setSellerId(seller.getSellerId());
		ob.setStatus("Pending");
		int itemId=itemService.saveItem(ob);
		if(itemId!=0)
			return "Item saved with Id:"+itemId;
		else
			return "Item not saved..";
	   }
//================View All Item==========================
	@POST
	@Path("/viewAllItem")
	public String showAllItem(){
			 String json=null;
		    	List<Item> itemList=itemService.getAllItem();
		    	//1.convert obj to json
			    json=jsonUtil.convertObjToJson(itemList);
		     return json;	
	    } 
	
	/*@POST
	@Path("/viewAllItem")
	public List<Item> showAllItem(){
		    	List<Item> itemList=itemService.getAllItem();
		    	//1.convert obj to json
			 return itemList;	
	    }*/
	
//================View Item by sellerId==========================
	@POST
	@Path("/viewItemBySellerId")
	public String showItemBySellerId(
	      @HeaderParam("sellerId")int sellerId){
	    String json=null;
    	List<Item> itemList=itemService.getAllItemBySellerId(sellerId);
    	//1.convert obj to json
	    json=jsonUtil.convertObjToJson(itemList);
     return json;
	    }
	
//===================View Item By Item Id====================
	@POST
	@Path("/viewItemByItemId")
	public String showItemByItemId(@HeaderParam("itemId")int itemId){
	    String json=null;
    	Item item=itemService.getItemById(itemId);
    	//1.convert obj to json
	    json=jsonUtil.convertObjToJson(item);
     return json;
	    }
	
	
//=========================Item Order=========================
	  //==================Order Item Save==================== 
	@POST
	@Path("/saveItemOrder")
	public String saveItemOrder(String json){
		
		ItemOrder ob=(ItemOrder)jsonUtil.convertJsonToObj(json, ItemOrder.class);
		if(ob==null)
			return "No item details found";
		int orderId=itemOrderService.saveItemOrder(ob);
		if(orderId!=0)
			return "Item Order saved with Id:"+orderId;
		else
			return "Item Order not saved..";
	   }
	
//======================Get Order Item by consId=========================
	@POST
	@Path("/viewItemOrderByConsId")
	public String showItemOrderByConsId(
	      @HeaderParam("consId")int consId){
	    String json=null;
    	List<ItemOrder> itemOrderList=itemOrderService.getAllOrderItemByConsId(consId);
    	//1.convert obj to json
	    json=jsonUtil.convertObjToJson(itemOrderList);
     return json;
	    }
//====================Update Item Order=================================
	
	
}