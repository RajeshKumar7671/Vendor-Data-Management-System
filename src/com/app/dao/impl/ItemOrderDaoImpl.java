package com.app.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.app.dao.IItemOrderDao;
import com.app.model.ItemOrder;
@Repository
public class ItemOrderDaoImpl  implements IItemOrderDao{
	
	@Autowired
	private HibernateTemplate ht;

	@Override
	public int saveItemOrder(ItemOrder itemOrder) {
		return (Integer) ht.save(itemOrder);			
	}

	@Override
	public List<ItemOrder> getAllOrderItem() {
		 return ht.loadAll(ItemOrder.class); 
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemOrder> getAllOrderItemByConsId(int consId) {
		List<ItemOrder> list=new ArrayList<ItemOrder>();
		String hql="from "+ ItemOrder.class.getName()+" where consId=?";
		list = ht.find(hql,consId);
		return list;
	}

	@Override
	public void deleteOrderItemByOrderId(int orderId) {
		ht.delete(new ItemOrder(orderId));
	}

	@Override
	public ItemOrder getOderItemByOrderId(int orderId) {
		return ht.get(ItemOrder.class, orderId);
	}

	@Override
	public void updateOrderItem(ItemOrder orderItem) {
		ht.update(orderItem);
		
	}

	@Override
	public boolean isOrderItemExist(String itemName) {
		boolean flag=false;
		String hql="select count(orderId) from "+ItemOrder.class.getName()
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
