package com.app.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.model.Consumer;
import com.app.services.IConsumerService;
import com.app.util.CodecUtil;

@Component
public class ConsumerValidator {
		
		@Autowired
		private CodecUtil codecUtil;
		@Autowired
		private IConsumerService service;
		
		
		public String doValidateConsumerEmail(String consEmail){
			String msg=null;
			if(service.isConsEmailExist(consEmail)){
				msg="'"+consEmail+"' already exist";
			}
			return msg;
		}
		/*
		 * This method will check request pwd and token
		 * values with DB encoded values (pwd,token) after decoding
		 */
		private boolean isValidPwdandToken(String reqPwd,String reqToken,Consumer cons){
			boolean flag=false;
			//read db values
			String ePwd=cons.getPwd();
			String eToken=cons.getToken();
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
		//of type Consumer-non select
		public boolean isValidConsForItemView(String reqPwd,String reqToken,Consumer cons){
		 boolean status=false;
	     if(isValidPwdandToken(reqPwd, reqToken, cons)){ status=true;}	
			return status;
		}
		/*
		 * This method will check request pwd 
		 * values with DB encoded values (pwd) after decoding
		 */
		public boolean isValidPwd(String reqPwd,Consumer cons){
			boolean flag=false;
			//read db values
			String ePwd=cons.getPwd();
			//decode them
			String dbPwd=codecUtil.doDecode(ePwd);
			//compare with req values
			if(dbPwd.equals(reqPwd))
			{
				flag=true;
			}
			return flag;
		}
}
