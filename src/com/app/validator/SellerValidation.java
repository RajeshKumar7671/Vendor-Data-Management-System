package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Seller;
import com.app.services.ISellerService;
import com.app.util.CodecUtil;

@Component
public class SellerValidation {

	@Autowired
	private CodecUtil codecUtil;
	@Autowired
	private ISellerService service;
	
	public String doValidateSellerEmail(String sellerEmail){
		String msg=null;
		if(service.isSellerEmailExist(sellerEmail)){
			msg="'"+sellerEmail+"' already exist";
		}
		return msg;
	}
	/*
	 * This method will check request pwd and token
	 * values with DB encoded values (pwd,token) after decoding
	 */
	private boolean isValidPwdandToken(String reqPwd,String reqToken,Seller seller){
		boolean flag=false;
		//read db values
		String ePwd=seller.getPwd();
		String eToken=seller.getToken();
		//decode them
		String dbPwd=codecUtil.doDecode(ePwd);
		String dbToekn=codecUtil.doDecode(eToken);
		//compare with req values
		if(dbPwd.equals(reqPwd) && dbToekn.equals(reqToken))
		{
			flag=true;
		}
		return flag;
	}
	
	//It returns true for non-select operations
	//of type SELLER-non select
	public boolean isValidSellerForItemProcess(String reqPwd,String reqToken,Seller seller){
	 boolean status=false;
     if(isValidPwdandToken(reqPwd, reqToken, seller)){
    	 status=true;
           }		
		return status;
	}	
	
}
