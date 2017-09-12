package com.app.services;

import com.app.model.Address;

public interface IAddressService {
	
	public int saveAddress(Address addr);
	public void deleteAddrressById(int addrId);	
	public Address getAddressById(int addrId);
	public void updateAddress(Address addr);

}
