package com.app.dao;

import com.app.model.Address;

public interface IAddressDao {
	
	public int saveAddress(Address addr);
	public void deleteAddrressById(int addrId);	
	public Address getAddressById(int addrId);
	public void updateAddress(Address addr);
}
