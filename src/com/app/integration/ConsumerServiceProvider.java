package com.app.integration;

import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Address;
import com.app.model.Consumer;
import com.app.model.ProfilePicture;
import com.app.services.IAddressService;
import com.app.services.IConsumerService;
import com.app.services.IProfilePictureService;
import com.app.util.CodeUtil;
import com.app.util.CodecUtil;
import com.app.util.CommonUtil;
import com.app.util.JsonUtil;
import com.app.validator.ConsumerValidator;

@Path("/consumerService")
@Component
public class ConsumerServiceProvider {
	@Autowired
	private IConsumerService service;
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
	private ConsumerValidator validator;
	@Autowired
	private JsonUtil jsonUtil;

	@POST
	@Path("/saveConsumer")
	public String saveConsumer(String json)
	  {
		    //1.convert json to class object
		  Consumer consObj=(Consumer)jsonUtil.convertJsonToObj(json, Consumer.class);
		    if(consObj==null)
			   return "No Consumer details found";

		   //2.generate pwd and token
		  String Pwd=codeUtil.getPwd();
		  String Token=codeUtil.getToken();
		
		   //3.convert above data to encoded format
		  String encPwd=codecUtil.doEncode(Pwd);
		  String encToken=codecUtil.doEncode(Token);
		
		   //4.set encoded pwd,tocken to seller obj
		  consObj.setToken(codecUtil.doEncode(encToken));
		  consObj.setPwd(codecUtil.doEncode(encPwd));
		
		      //check data with validator 
	      String msg=validator.doValidateConsumerEmail(consObj.getConsEmail());
		    if(msg!=null){
	            //data has error
	           return msg;
		     }
		    else
		      {
		   Address addr=new Address();
		 addrService.saveAddress(addr);
		      consObj.setAddr(addr);  
		ProfilePicture proImage=new ProfilePicture();
		proImageService.saveProfilePicture(proImage);
		      consObj.setProImage(proImage);
	            //save data-no error
		    //5.save data to d
	      int consId=service.saveConsumer(consObj);
		    //6.send email
		    if(consId!=0)
		       {
	      String subject="Hello Mr/Ms/Mrs. "+consObj.getConsFirstName()+" "+consObj.getConsLastName()+".This is regarding registration to Consumer.";
	      String message="You are Successfully registered as a Consumer.Your Password is: "+Pwd+" and accessToken is: "+Token 
				+"  User Name is :"+consObj.getConsEmail();
		  commonUtil.sendEmail(consObj.getConsEmail(), subject, message);
		       }
		    //7.send message to UI
		  if(consId!=0)
			return "Consumer saved with Id:"+consId;
		   else
			return "Consumer not saved..";
	         }
        }
	
	//===========Login Consumer in Vendor DB=============      
	@POST
	@Path("/loginConsumer")
	public String loginSeller(
			@HeaderParam("username")String un,
			@HeaderParam("password")String pwd){
		
		  String json=null;
		//user name should not be empty or null
		  if(un==null || "".equals(un.trim()))
			return json;
		// encode the user password
		   String encPwd=codecUtil.doEncode(pwd);
	     Consumer cons=service.getConsumerByUmailAndPwd(un, encPwd);
	     if(cons!=null)
	        {
	    	//1.convert obj to json
		        json=jsonUtil.convertObjToJson(cons);
	    	return  json; 
	        }
	     return json;
	   }
//=====================View Consumer By Id==================
	@POST
	@Path("/viewConsByConsId")
	public String getConsumerBySellerId(
			@HeaderParam("consId")int consId){

		  String json=null;
	     Consumer cons =service.getConsumerById(consId);
	     if(cons!=null)
	        {
	    	//1.convert obj to json
		   return json=jsonUtil.convertObjToJson(cons); 
	        }
	     return json;
	   }
//===========Update Consumer in Vendor DB=============
    
		@POST
		@Path("/updateConsumer")
		public String updateConsumerByRest(String json){
			
	     Consumer consObj=(Consumer)jsonUtil.convertJsonToObj(json, Consumer.class);
			    if(consObj==null)
				   return "No Seller details found";
		    service.updateCons(consObj);

		     return "Update Sucessfully!";
		 }
	
 //===========Update Address by in Vendor DB=============
	    
		@POST
		@Path("/updateAddress")
		public String updateAddressByRest(String json){
			
	     Address addrObj=(Address)jsonUtil.convertJsonToObj(json, Address.class);
			    if(addrObj==null)
				   return "No Consumer details found";
		    addrService.updateAddress(addrObj);
		     return "Update Sucessfully!";
		 }
//===========Update Address by in Vendor DB=============
	    
		@POST
		@Path("/changeConsumerPwd")
		public String changeConsumerPassword(
				@HeaderParam("consId")int consId,
				@HeaderParam("oldPwd")String oldPwd,
				@HeaderParam("newPwd")String newPwd){
			
			String msg=null;
			String encOldPwd=codecUtil.doEncode(oldPwd);
			String encNewPwd=codecUtil.doEncode(newPwd);
			
			Consumer cons=service.getConsumerById(consId);
			   String dbPwd=cons.getPwd();
			   
			    if(dbPwd.equals(encOldPwd))
			    {
			    cons.setPwd(encNewPwd);
			    service.updateCons(cons);
		        msg="Update Sucessfully!";
			    }
			    else
			    	msg="Password not Mathched";
			    	
			return msg;    	
		 }
	
	
}
