package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IConsumerDao;
import com.app.model.Consumer;
import com.app.services.IConsumerService;

@Service
public class ConsumerServiceImpl implements IConsumerService{
	
	@Autowired
	private IConsumerDao dao;
	
	@Override
	public Consumer getConsumerByUmailAndPwd(String consEmail, String pwd) {
		return dao.getConsumerByUmailAndPwd(consEmail, pwd);
	}
	
	@Override
	public int saveConsumer(Consumer cons) {
		return (Integer)dao.saveConsumer(cons);
	}
	
	@Override
	public List<Consumer> getAllConsumer() {
		return dao.getAllConsumer();
	}
	
	@Override
	public void deleteConsById(int consId) {
	dao.deleteConsById(consId);
		
	}
	@Override
	public Consumer getConsumerById(int consId) {
		return dao.getConsumerById(consId);
	}
	@Override
	public void updateCons(Consumer cons) {
		dao.updateCons(cons);
		
	}
	@Override
	public boolean isConsEmailExist(String consEmail) {
		return dao.isConsEmailExist(consEmail);
	}
	@Override
	public Consumer getConsObByEmailId(String emailId) {
		return dao.getConsObByEmailId(emailId);
	}

}
