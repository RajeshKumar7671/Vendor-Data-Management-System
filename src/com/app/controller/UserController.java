package com.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.app.model.Address;
import com.app.model.ProfilePicture;
import com.app.model.User;
import com.app.services.IAddressService;
import com.app.services.IProfilePictureService;
import com.app.services.IUserServices;
import com.app.util.CodeUtil;
import com.app.util.CommonUtil;
import com.app.validator.UserValidator;
@Controller
public class UserController {
	@Autowired
	private IUserServices service;
	@Autowired
	private IProfilePictureService profilePictService;
	@Autowired
	private CodeUtil codeUtil;
	@Autowired
	private CommonUtil commonUtil;
	@Autowired
	private UserValidator validator;
	@Autowired
	private IAddressService addrService;
	
	@RequestMapping("/admin")
	public String showAdminRegPage(ModelMap map)
	  {
		return "AdminReg";
	  }
	@RequestMapping(value="/insertUser",method=RequestMethod.POST)
	public String saveUser(
			@ModelAttribute("picturePicture")ProfilePicture pictureObj,
			@ModelAttribute("address")Address addr,
			@ModelAttribute("user")User user,ModelMap map){
		//gen pwd and set obj
		String pwd=codeUtil.getPwd();
		user.setUserPwd(pwd);
		//check data with validator 
		String msg=validator.doValidateUserEmail(user.getUserEmail());
		  if(msg!=null){
		//data has error
	    map.addAttribute("msg",msg);
	      return "AdminReg";
		}else{
		//Insert Profile picture obj to DB using SL
		profilePictService.saveProfilePicture(pictureObj);
		  user.setProImage(pictureObj);
		  
	    //insert address obj to DB using SL
		addrService.saveAddress(addr);
		   user.setAddr(addr); 
		//save obj to DB using SL
		int userId=service.saveUser(user);
		//send msg to UI
		map.addAttribute("msg","User Registered with Id:"+userId);
		//send email
		String subject="Hello Mr/Ms/Mrs. "+user.getUserFirstName()+""+user.getUserLastName()+".This is regarding registration to VDM.";
		String message="You are Successfully registered as a Admin.Your Password is: "+user.getUserPwd()+" and " 
					+". User Name is :"+user.getUserEmail();
		commonUtil.sendEmail(user.getUserEmail(), subject,message);
		return "HomePage";
		}
	 }
	
	/**
	 * Login process
	 */
	@RequestMapping(value="/loginUser",method=RequestMethod.POST)
	public String doLoginUser(
			@RequestParam("userId")String userEmail,
			@RequestParam("password")String pwd,
			HttpServletRequest req,ModelMap map){
	
		String pageName=null;
		User user=service.getUserByUmailAndPwd(userEmail, pwd);
		if(user!=null){
			//create session and goto home page
			HttpSession ses=req.getSession();
			ses.setAttribute("userObj",user);
			pageName="VdmHome";
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
	@RequestMapping("/userLogout")
	public String doLogout(HttpServletRequest req,ModelMap map){
		//read current session of user
		HttpSession ses=req.getSession(false);
		ses.setAttribute("userObj", null);
		ses.invalidate();
		map.addAttribute("msg", "Logout success...");
		return "HomePage";
	}
	
	//========Admin Profile========
	@RequestMapping("/adminPro")
	public String showAdminProfilePage(@RequestParam("userId")int userId,ModelMap map)
	 {
		User user=service.getUserById(userId);
		map.addAttribute("userObject",user);
	   return "AdminProfile";
     }
	@RequestMapping("/adminSett")
	public String showAdminSetting(@RequestParam("userId")int userId,ModelMap map)
	 {
	   User user=service.getUserById(userId);
		map.addAttribute("userObject",user);
	   return "AdminSetting";
     }
	@RequestMapping("/adminChangePwd")
	public String showSellerChangePassword(@RequestParam("userId")int userId,ModelMap map)
	{
	   User user=service.getUserById(userId);
	   map.addAttribute("userObject",user);
       return "AdminChangePassword";
    }
	@RequestMapping(value="/updateAdminProfilePicture",method=RequestMethod.POST)
	public String updateProfilePicture(
			@RequestParam("profileImageName")CommonsMultipartFile proImage){
		 String profileName=proImage.getOriginalFilename();
			byte[] arr=proImage.getBytes();
			ProfilePicture proImageObj=new ProfilePicture();
			proImageObj.setProfileImageName(profileName);
			proImageObj.setPrifileImageData(arr);
			profilePictService.updateProfilePicture(proImageObj);
			return "redirect:adminSett";
	  }
	
	@RequestMapping(value="/adminUpdate",method=RequestMethod.POST)
	public String updateUserData(@ModelAttribute("user")User user,ModelMap map){
		//Get userId by POJO Object
	       int userId=user.getUserId();
	     //Get data from DB by using userId
	     User userObj=service.getUserById(userId);
	         user.setAddr(userObj.getAddr());
	         user.setProImage(userObj.getProImage());
	      //Update user data in DB
		   service.updateUser(user);
		   //Send to UI
		  user=service.getUserById(userId);
		  map.addAttribute("userObject",user);
		return "AdminSetting";
    	}
	 @RequestMapping(value="/addrUpdate",method=RequestMethod.POST)
	 public String updateAddressData(@RequestParam("userId")int userId,
	    @ModelAttribute("address")Address addr,ModelMap map){
		 User user=service.getUserById(userId);
		int addrId=user.addr.getAddrId();
		addr.setAddrId(addrId);
		addrService.updateAddress(addr);
		//Data send to the UI
		 user=service.getUserById(userId);
		map.addAttribute("userObject",user);
	   return "AdminSetting";
	  }

	 @RequestMapping(value="/admindChangePassword",method=RequestMethod.POST)
		public String changeAdminPassword(
				@RequestParam("userId")int userId,
				@RequestParam("oldPwd")String oldPwd,
				@RequestParam("pwd")String pwd,
				@RequestParam("conformPwd")String conformPwd,ModelMap map){
		 User user=service.getUserById(userId);
		    String dbPwd=user.getUserPwd();
		    if(dbPwd.equals(oldPwd)){
		     user.setUserPwd(pwd);
			 service.updateUser(user);
		     }
		   user=service.getUserById(userId);
		  map.addAttribute("userObject",user);
		 return "AdminChangePassword";
		}
}

