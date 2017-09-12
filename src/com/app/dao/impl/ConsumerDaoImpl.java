package com.app.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IConsumerDao;
import com.app.model.Consumer;
@Repository
public class ConsumerDaoImpl implements IConsumerDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Consumer getConsumerByUmailAndPwd(String consEmail, String pwd) {
		Consumer cons=null;
		String hql="from "+ Consumer.class.getName()+" where consEmail=? and Pwd=?";
		@SuppressWarnings("unchecked")
		List<Consumer> consList=ht.find(hql, consEmail,pwd);
		if(consList!=null && !consList.isEmpty()){
			cons=consList.get(0);
		}
		return cons;
	}
	
	@Override
	public int saveConsumer(Consumer cons) {
		return (Integer)ht.save(cons);
	}
	
	@Override
	public List<Consumer> getAllConsumer() {
		return ht.loadAll(Consumer.class);
	}
	
	@Override
	public void deleteConsById(int consId) {
		ht.delete(new Consumer(consId));
	}
	
	public Consumer getConsumerById(int consId) {
		return ht.get(Consumer.class, consId);
	}
	
	@Override
	public void updateCons(Consumer cons) {
		ht.update(cons);
		}
	
	@Override
	public boolean isConsEmailExist(String consEmail) {
		boolean flag=false;
		String hql="select count(consId) from "+Consumer.class.getName()
				+" where consEmail=?";
		@SuppressWarnings("unchecked")
		List<Long>dataList=ht.find(hql,consEmail);
		
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	   }
	
	@Override
	public Consumer getConsObByEmailId(String emailId){
		Consumer cons=null;
		String hql="from "+Consumer.class.getName()
				+" where consEmail=?";
		@SuppressWarnings("unchecked")
		List<Consumer> consList=ht.find(hql, emailId);
		if(consList!=null && !consList.isEmpty()){
			cons=consList.get(0);
		}
		return cons;
	}
	

}
