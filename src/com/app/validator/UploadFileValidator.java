package com.app.validator;

import org.springframework.stereotype.Component;

import com.app.model.UploadFile;

@Component
public class UploadFileValidator {
	
	public String doValidateFile(UploadFile fileObj )
	     {
		String valMsg=null;
	      if(fileObj.getFileName().isEmpty()) 
	    	 valMsg="File is Empty Please Select File"; 
	      if(fileObj.getFileData().length>20971520)
	    	  valMsg="Please select less 20 MB ";
	      return valMsg;
	      }
   }
