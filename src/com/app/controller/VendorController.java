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

import com.app.model.Address;
import com.app.model.Location;
import com.app.model.ProfilePicture;
import com.app.model.Vendor;
import com.app.services.IAddressService;
import com.app.services.IProfilePictureService;
import com.app.services.IVendorServices;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.util.LocationUtil;
import com.app.validator.VendorValidator;

@Controller
public class VendorController {
	
	@Autowired
	private IVendorServices service;
	@Autowired
	private IAddressService addrService;
	@Autowired
	private IProfilePictureService profileService;
	@Autowired
	private CommonUtil commonUtil;
	
	@Autowired
	private CodeUtil codeUtil;
	
	@Autowired
	private VendorValidator validator;
	
	/**
	 * To integrate location with
	 * vendor using Locationutil
	 * has-a with vendorcontroller
	 */
	@Autowired
	private LocationUtil locUtil;
	
	@RequestMapping("/regVen")
	public String showVenReg(ModelMap map)
	{
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj",locList);
		return "VendorReg";
	}
	/**
	 * Use this below method
	 * to save data.
	 * On click submit from UI
	 * page request should come to here
	 * as post Type,
	 * read model attribute name:vendor 
	 * copy to local variable
	 */
	@RequestMapping(value="/insertVen",method=RequestMethod.POST)
	public String saveVendorData(
			@ModelAttribute("picturePicture")ProfilePicture pictureObj,
			@ModelAttribute("address")Address addr,
			@ModelAttribute("vendor")Vendor ven,
			ModelMap map){
		//gen pwd and set obj
		String pwd=codeUtil.getPwd();
		    ven.setVenPwd(pwd);
		//check data with validator 
		String venRegMsg=validator.doValidateVenEmail(ven.getVenEmail());
		if(venRegMsg!=null){
			//data has error
			map.addAttribute("venRegMsg",venRegMsg);
		}else{
			//Insert Profile picture obj to DB using SL
			profileService.saveProfilePicture(pictureObj);
			  ven.setProImage(pictureObj);
			  
		    //insert address obj to DB using SL
			addrService.saveAddress(addr);
			   ven.setAddr(addr);   
			   
			//save data-no error
		int venId=service.saveVendor(ven);
		venRegMsg="Vendor Saved with id:"+venId;
		map.addAttribute("venRegMsg", venRegMsg);
		//send email
			if(venId!=0)
			  {
	     String subject="Hello Mr/Ms/Mrs. "+ven.getVenFirstName()+" "+ven.getVenLastName()+".This is regarding registration to VDM.";
	     String message="You are Successfully registered as a Vendor.Your Password is: "+pwd+". User Name is :"+ven.getVenEmail();
				commonUtil.sendEmail(ven.getVenEmail(), subject, message);
			   }
		    }
		/**adding lines to display locations after insert*/ 
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList );
		/**End*/
		return "VendorReg";
	}
	/**
	 * This method is used to
	 * fetch all records from DB
	 * using SL and sends to UI
	 * using ModelMap , it is executed
	 * when 'viewAllVen' req is made
	 * It can be called from InsertVen Page
	 */
	//provide url
	@RequestMapping("/viewAllVen")
	public String showAllVen(ModelMap map){
		//read data from SL
		List<Vendor> venList=service.getAllVendor();
		//send to UI 
		map.addAttribute("venListObj", venList);
		//specify UI page name
		return  "VendorData";
	}
	@RequestMapping("/venDetails")
	public String showVendorDetailsPage(@RequestParam("venId")int venId,ModelMap map)
	 {
	   Vendor ven=service.getVendorById(venId);
	   map.addAttribute("venObject",ven);
	   return "VendorDetails";
     }
	/**
	 * This method is used to 
	 * display edit page/update page
	 * when user clicks on update
	 * link. It will display editpage
	 * with data reads from DB using id
	 * It goes to VendorUpdate JSP page
	 */
	@RequestMapping("/updateVen")
	public String showEditPage(@RequestParam("venId")int venId,ModelMap map){
		/**adding lines to display locations before update*/ 
		List<Location> locList=locUtil.getAllLocations();
		map.addAttribute("locListObj", locList );
		/**End*/
		Vendor ven=service.getVendorById(venId);
		map.addAttribute("venObject",ven);
		return "VendorUpdate";
	}
	/**
	 * this method is used to
	 * get obj from UI form
	 * and sends to service layer
	 * and redirect to Show Page.
	 * THis is type POST.
	 */
	@RequestMapping(value="/venUpdate",method=RequestMethod.POST)
	public String updateVenData(
	  @ModelAttribute("vendor")Vendor ven){
		service.updateVen(ven);
		return "redirect:viewAllVen";
	}
	
	/**
	 * This method is used to delete
	 * data from database
	 * and sending all in UI page
	 */
	@RequestMapping("deleteVen")
	public String deleteVen(@RequestParam("venId")int id)
	{
		service.deleteVenById(id);
		return "redirect:viewAllVen";
	}
	
	/**
	 * This method will be
	 * executed on click of hyper link for
	 * data export to excel. fetch data from DB
	 * using service layer and send to
	 * ExcelView impl class with ModelMap help.  
	 */
	@RequestMapping("/venExcelExport")
	public String exportDataExcel(ModelMap map){
		List<Vendor> venList=service.getAllVendor();
		map.addAttribute("venListObj", venList);
		return "VenExcel";
	}
	
	/**
	 * for pdf export
	 * 
	 */
	@RequestMapping("/venPdfExport")
	public String exportDataPdf(ModelMap map){
		List<Vendor> venList=service.getAllVendor();
		map.addAttribute("venListObj", venList);
		return "VenPdf";
	}
	
	/**
	 * Login process
	 */
	@RequestMapping(value="/loginVen",method=RequestMethod.POST)
	public String doLoginVendor(
			@RequestParam("username")String venEmail,
			@RequestParam("password")String pwd,
			HttpServletRequest req,ModelMap map){
	
		String pageName=null;
		Vendor ven=service.getVendorByUmailAndPwd(venEmail, pwd);
		if(ven!=null){
			//create session and goto home page
			HttpSession ses=req.getSession();
			ses.setAttribute("venObj",ven);
			pageName="VendorHome";
		}else{
			//create error msg and goto login page
			map.addAttribute("msg", "Worng username or password!");
			pageName="HomePage";
		}
	   return pageName;	
	   }
	  /**
	    * Logout process
	   */
	  @RequestMapping("/logoutVen")
	  public String doVendorLogout(HttpServletRequest req,ModelMap map){
		//read current session of user
		HttpSession ses=req.getSession(false);
		ses.setAttribute("venObj", null);
		ses.invalidate();
		map.addAttribute("msg", "Logout success...");
		return "HomePage";
	    }
	@RequestMapping("/venHome")
	public String showVendorHomePage()
	 {
	   return "VendorHome";
     }
	
	//========Vendor Profile========
	@RequestMapping("/venPro")
	public String showVendorProfilePage(@RequestParam("venId")int venId,ModelMap map)
	 {
	   Vendor ven=service.getVendorById(venId);
	   map.addAttribute("venObject",ven);
	   return "VendorProfile";
     }
	@RequestMapping("/venSett")
	public String showVendorSetting(@RequestParam("venId")int venId,ModelMap map)
	 {
	   Vendor ven=service.getVendorById(venId);
	   map.addAttribute("venObject",ven);
	   return "VendorSetting";
     }
	@RequestMapping("/venChangePwd")
	public String showVendorChangePassword(@RequestParam("venId")int venId,ModelMap map)
	   {
		 Vendor ven=service.getVendorById(venId);
		 map.addAttribute("venObject",ven);
       return "VendorChangePassword";
       }
    
	  @RequestMapping(value="/venSettUpdate",method=RequestMethod.POST)
		public String updateUserData(@ModelAttribute("ven")Vendor ven,ModelMap map){
			//Get venId by POJO Object
		       int venId=ven.getVenId();
		     //Get data from DB by using venId
		     Vendor venObj=service.getVendorById(venId);
		         ven.setVenProfId(venObj.getVenProfId());
		         ven.setLoc(venObj.getLoc());
		         ven.setAddr(venObj.getAddr());
		         ven.setProImage(venObj.getProImage());
		      //Update Vendor data in DB
			   service.updateVen(ven);
			   //Send to UI
			  venObj=service.getVendorById(venId);
			  map.addAttribute("venObject",venObj);
			return "VendorSetting";
	    	}
	 
	  @RequestMapping(value="/venAddrUpdate",method=RequestMethod.POST)
		 public String vendorAddressUpdateData(@RequestParam("venId")int venId,
		    @ModelAttribute("address")Address addr,ModelMap map){
			 Vendor ven=service.getVendorById(venId);
			   addr.setAddrId(ven.addr.getAddrId());
			addrService.updateAddress(addr);
			//Data send to the UI
			 ven=service.getVendorById(venId);
			map.addAttribute("venObject",ven);
		   return "VendorSetting";
		  }

	  @RequestMapping(value="/venChangePassword",method=RequestMethod.POST)
		public String changeVendorPassword(
				@RequestParam("venId")int venId,
				@RequestParam("oldPwd")String oldPwd,
				@RequestParam("pwd")String pwd,
				@RequestParam("conformPwd")String conformPwd,ModelMap map){
		 Vendor ven=service.getVendorById(venId);
		    String dbPwd=ven.getVenPwd();
		    if(dbPwd.equals(oldPwd)){
		     ven.setVenPwd(pwd);
			 service.updateVen(ven);
		     }
		   ven=service.getVendorById(venId);
		  map.addAttribute("venObject",ven);
		 return "VendorChangePassword";
		}
	
}
