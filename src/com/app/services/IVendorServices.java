package com.app.services;

import java.util.List;

import com.app.model.Vendor;

public interface IVendorServices {
	
	public int saveVendor(Vendor ven);
	
	public List<Vendor> getAllVendor();
	
	public void deleteVenById(int venId);
	
	public Vendor getVendorByUmailAndPwd(String venEmail,String pwd);
	
	public Vendor getVendorById(int venId);
	
	public void updateVen(Vendor ven);
	
	public boolean isVenEmailExist(String venEmail);

}
