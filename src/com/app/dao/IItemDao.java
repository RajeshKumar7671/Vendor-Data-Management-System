package com.app.dao;

import java.util.List;

import com.app.model.Item;

public interface IItemDao {
	
	public int saveItem(Item item);
	
	public List<Item> getAllItem();
	
	public List<Item> getAllItemBySellerId(int sellerId);
	
    public void deleteItemById(int itemId);
	
	public Item getItemById(int itemId);
	
	public void updateItem(Item item);
	
	public boolean isItemExist(String itemName);

}
