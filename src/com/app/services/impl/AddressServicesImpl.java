package com.app.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IAddressDao;
import com.app.model.Address;
import com.app.services.IAddressService;

@Service
public class AddressServicesImpl implements IAddressService {
	@Autowired
	private IAddressDao dao;
	
	@Override
	public int saveAddress(Address addr) {
		return dao.saveAddress(addr);
	}
	
	@Override
	public Address getAddressById(int addrId) {
		return dao.getAddressById(addrId);
	}
	
	@Override
	public void updateAddress(Address addr) {
	  dao.updateAddress(addr);	
	}
	
	@Override
	public void deleteAddrressById(int addrId) {
		dao.deleteAddrressById(addrId);
		
	}

}
