package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.ISellerDao;
import com.app.model.Seller;

@Repository
public class SellerDaoImpl implements ISellerDao{
	
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Seller getSellerByUmailAndPwd(String sellerEmail, String pwd) {
		Seller seller=null;
		String hql="from "+ Seller.class.getName()+" where sellerEmail=? and Pwd=?";
		@SuppressWarnings("unchecked")
		List<Seller> sellerList=ht.find(hql, sellerEmail,pwd);
		if(sellerList!=null && !sellerList.isEmpty()){
			seller=sellerList.get(0);
		}
		return seller;
	}
	
	@Override
	public int saveSeller(Seller seller) {
		return (Integer)ht.save(seller);
	}
	
	@Override
	public List<Seller> getAllSeller() {
		return ht.loadAll(Seller.class);
	}
	
	@Override
	public void deleteSellerById(int sellerId) {
		ht.delete(new Seller(sellerId));
	}
	
	public Seller getSellerById(int sellerId) {
		return ht.get(Seller.class, sellerId);
	}
	
	@Override
	public void updateSeller(Seller seller) {
		ht.update(seller);
		}
	
	@Override
	public boolean isSellerEmailExist(String sellerEmail) {
		boolean flag=false;
		String hql="select count(sellerId) from "+Seller.class.getName()
				+" where sellerEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,sellerEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	   }
	
	@Override
	public Seller getSellerObByEmailId(String emailId){
		Seller seller=null;
		String hql="from "+Seller.class.getName()
				+" where sellerEmail=?";
		@SuppressWarnings("unchecked")
		List<Seller> sellerList=ht.find(hql, emailId);
		if(sellerList!=null && !sellerList.isEmpty()){
			seller=sellerList.get(0);
		}
		return seller;
	}
	

}
