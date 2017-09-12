package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemDao;
import com.app.model.Item;
@Repository
public class ItemDaoImpl implements IItemDao{
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public int saveItem(Item item) {
		return (Integer)ht.save(item);
	}
	
	@Override
	public List<Item> getAllItem() {
	 List<Item> list=new ArrayList<Item>();  
		 list=ht.loadAll(Item.class); 
      return list;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Item> getAllItemBySellerId(int sellerId) {
		List<Item> list=new ArrayList<Item>();
		String hql="from "+ Item.class.getName()+" where sellerId=?";
		list=ht.find(hql,sellerId);
		return list;
	}
	
	@Override
	public void deleteItemById(int itemId) {
		ht.delete(new Item(itemId));
	}
	@Override
	public Item getItemById(int itemId) {
		return ht.get(Item.class, itemId);
	}
	
	@Override
	public void updateItem(Item item) {
		ht.update(item);
		}
	
	@Override
	public boolean isItemExist(String itemName) {
		boolean flag=false;
		String hql="select count(itemId) from "+Item.class.getName()
				+" where itemName=?";
		@SuppressWarnings("unchecked")
		List<Long> dataList=ht.find(hql,itemName);
	
		if(dataList!=null && !dataList.isEmpty()){
			long count=dataList.get(0);
			if(count>0) flag=true;
		     }
		return flag;
	   }
}
