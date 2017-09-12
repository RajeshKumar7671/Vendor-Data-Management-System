package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemDao;
import com.app.model.Item;
import com.app.services.IItemServices;

@Service
public class ItemServicesImpl implements IItemServices{
	@Autowired
	private IItemDao dao;
	
	@Override
	public int saveItem(Item item) {
		return dao.saveItem(item);
	}
	@Override
	public Item getItemById(int itemId) {
		return dao.getItemById(itemId);
	}
	@Override
	public List<Item> getAllItem() {
		return dao.getAllItem();			
	}
	@Override
	public List<Item> getAllItemBySellerId(int sellerId) {
		return dao.getAllItemBySellerId(sellerId);
	}
	@Override
	public void updateItem(Item item) {
		dao.updateItem(item);
	}
	@Override
	public void deleteItemById(int itemId) {
		dao.deleteItemById(itemId);
	}
	@Override
	public boolean isItemExist(String itemName) {
		return dao.isItemExist(itemName);
	}
}
