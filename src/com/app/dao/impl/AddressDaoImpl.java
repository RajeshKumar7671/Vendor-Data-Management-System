package com.app.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IAddressDao;
import com.app.model.Address;
@Repository
public class AddressDaoImpl implements IAddressDao {
	@Autowired
	 private HibernateTemplate ht;
	
	@Override
	public int saveAddress(Address addr) {
		return (int) ht.save(addr);
	}
    @Override
    public Address getAddressById(int addrId) {	
	return ht.get(Address.class,addrId);
    }
    
    @Override
    public void updateAddress(Address addr) {
    	ht.update(addr);
    }
    @Override
    public void deleteAddrressById(int addrId) {
       ht.delete(new Address(addrId));
    }
	
}
