package com.app.services;

import java.util.List;

import com.app.model.Seller;

public interface ISellerService {
	
    public int saveSeller(Seller seller);
	
	public List<Seller> getAllSeller();
	
    public void deleteSellerById(int sellerId);
	
	public Seller getSellerById(int sellerId);
	
	public void updateSeller(Seller seller);
	
	public boolean isSellerEmailExist(String sellerEmail);

	public Seller getSellerObByEmailId(String emailId);
	
	public Seller getSellerByUmailAndPwd(String sellerEmail,String pwd);

}
