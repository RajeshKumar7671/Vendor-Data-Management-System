package com.app.integration;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Address;
import com.app.model.ProfilePicture;
import com.app.model.Seller;
import com.app.services.IAddressService;
import com.app.services.IProfilePictureService;
import com.app.services.ISellerService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;
import com.app.util.JsonUtil;
import com.app.validator.SellerValidation;

@Path("/sellerService")
@Component
public class SellerServiceProvider {
	@Autowired
	private ISellerService service;
	@Autowired
	private IAddressService addrService;
	@Autowired
	private IProfilePictureService proImageService;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private SellerValidation validator;
	@Autowired
	private JsonUtil jsonUtil;

	@POST
	@Path("/saveSeller")
	public String saveSeller(String json)
	  {
		    //1.convert json to class object
		  Seller sellerObj=(Seller)jsonUtil.convertJsonToObj(json, Seller.class);
		    if(sellerObj==null)
			   return "No Seller details found";

		   //2.generate pwd and token
		  String Pwd=codeUtil.getPwd();
		  String Token=codeUtil.getToken();
		
		   //3.convert above data to encoded format
		  String encPwd=codecUtil.doEncode(Pwd);
		  String encToken=codecUtil.doEncode(Token);
		
		   //4.set encoded pwd,tocken to seller obj
		  sellerObj.setToken(codecUtil.doEncode(encToken));
		  sellerObj.setPwd(codecUtil.doEncode(encPwd));
		
		      //check data with validator 
	      String msg=validator.doValidateSellerEmail(sellerObj.getSellerEmail());
		    if(msg!=null){
	            //data has error
	           return msg;
		     }
		    else
		      {
		    Address addr=new Address();
	            //save data-no error
		     addrService.saveAddress(addr);
			   sellerObj.setAddr(addr);  
			ProfilePicture proImage=new ProfilePicture();
			 proImageService.saveProfilePicture(proImage);
			   sellerObj.setProImage(proImage);
		    //5.save data to database
	      int sellerId=service.saveSeller(sellerObj);
		    //6.send email
		    if(sellerId!=0)
		       {
	      String subject="Hello Mr/Ms/Mrs. "+sellerObj.getSellerFirstName()+" "+sellerObj.getSellerLastName()+".This is regarding registration to Seller Hub.";
	      String message="You are Successfully registered as a Seller.Your Password is: "+Pwd+" and accessToken is: "+Token 
				+"  User Name is :"+sellerObj.getSellerEmail();
		  commonUtil.sendEmail(sellerObj.getSellerEmail(), subject, message);
		       }
		    //7.send message to UI
		  if(sellerId!=0)
			return "Seller saved with Id:"+sellerId;
		   else
			return "Seller not saved..";
	         }
        }
	
	//===========Login Seller in Vendor DB=============
	       
	@POST
	@Path("/loginSeller")
	public String loginSeller(
			@HeaderParam("username")String un,
			@HeaderParam("password")String pwd){
		
		  String json=null;
		//user name should not be empty or null
		  if(un==null || "".equals(un.trim()))
			return null;
		// encode the user password
		  String encPwd=codecUtil.doEncode(pwd);
	     Seller seller=service.getSellerByUmailAndPwd(un, encPwd);
	     if(seller!=null)
	        {
	    	//1.convert obj to json
		   return json=jsonUtil.convertObjToJson(seller); 
	        }
	     return json;
	   }
	//===========Get Seller by sellerId in Vendor DB=============
    
		@POST
		@Path("/viewSellerBySellerId")
		public String getSellerBySellerId(
				@HeaderParam("sellerId")int sellerId){
	
			  String json=null;
		     Seller seller=service.getSellerById(sellerId);
		     if(seller!=null)
		        {
		    	//1.convert obj to json
			   return json=jsonUtil.convertObjToJson(seller); 
		        }
		     return json;
		   }
   //===========Update Seller in Vendor DB=============
	    
			@POST
			@Path("/updateSeller")
			public String updateSellerByRest(String json){
				
		     Seller sellerObj=(Seller)jsonUtil.convertJsonToObj(json, Seller.class);
				    if(sellerObj==null)
					   return "No Seller details found";
			    service.updateSeller(sellerObj);
	
			     return "Update Sucessfully!";
			 }
		
     //===========Update Address by in Vendor DB=============
		    
			@POST
			@Path("/updateAddress")
			public String updateAddressByRest(String json){
				
		     Address addrObj=(Address)jsonUtil.convertJsonToObj(json, Address.class);
				    if(addrObj==null)
					   return "No Seller details found";
			    addrService.updateAddress(addrObj);
			     return "Update Sucessfully!";
			 }
 //===========Update Address by in Vendor DB=============
		    
			@POST
			@Path("/changeSellerPwd")
			public String changeSellerPassword(
					@HeaderParam("sellerId")int sellerId,
					@HeaderParam("oldPwd")String oldPwd,
					@HeaderParam("newPwd")String newPwd){
				
				String msg=null;
				String encOldPwd=codecUtil.doEncode(oldPwd);
				String encNewPwd=codecUtil.doEncode(newPwd);
				
				Seller seller=service.getSellerById(sellerId);
				   String dbPwd=seller.getPwd();
				   
				    if(dbPwd.equals(encOldPwd))
				    {
				    seller.setPwd(encNewPwd);
				    service.updateSeller(seller);
			        msg="Update Sucessfully!";
				    }
				    else
				    	msg="Password not Mathched";
				    	
				return msg;    	
			 }
  }