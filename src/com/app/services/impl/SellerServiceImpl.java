package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ISellerDao;
import com.app.model.Seller;
import com.app.services.ISellerService;

@Service
public class SellerServiceImpl implements ISellerService{

	@Autowired
	private ISellerDao dao;
	
	
	@Override
	public Seller getSellerByUmailAndPwd(String sellerEmail, String pwd) {
		return dao.getSellerByUmailAndPwd(sellerEmail, pwd);
	}
	
	@Override
	public int saveSeller(Seller seller) {
		return (Integer)dao.saveSeller(seller);
	}
	
	@Override
	public List<Seller> getAllSeller() {
		return dao.getAllSeller();
	}
	
	@Override
	public void deleteSellerById(int sellerId) {
	dao.deleteSellerById(sellerId);
		
	}
	@Override
	public Seller getSellerById(int sellerId) {
		return dao.getSellerById(sellerId);
	}
	@Override
	public void updateSeller(Seller seller) {
		dao.updateSeller(seller);
		
	}
	@Override
	public boolean isSellerEmailExist(String sellerEmail) {
		return dao.isSellerEmailExist(sellerEmail);
	}
	@Override
	public Seller getSellerObByEmailId(String emailId) {
		return dao.getSellerObByEmailId(emailId);
	}
	
	

}
