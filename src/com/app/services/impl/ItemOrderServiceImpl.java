package com.app.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.IItemOrderDao;
import com.app.model.ItemOrder;
import com.app.services.IItemOrderService;

@Service
public class ItemOrderServiceImpl implements IItemOrderService {
	
	@Autowired
	private IItemOrderDao dao;

	@Override
	public int saveItemOrder(ItemOrder itemOrder) {
		return dao.saveItemOrder(itemOrder);
	}

	@Override
	public List<ItemOrder> getAllOrderItem() {
		return dao.getAllOrderItem();
	}

	@Override
	public List<ItemOrder> getAllOrderItemByConsId(int consId) {
		return dao.getAllOrderItemByConsId(consId);
	}

	@Override
	public void deleteOrderItemByOrderId(int orderId) {
		dao.deleteOrderItemByOrderId(orderId);
	}

	@Override
	public ItemOrder getOderItemByOrderId(int orderId) {
		return dao.getOderItemByOrderId(orderId);
	}

	@Override
	public void updateOrderItem(ItemOrder orderItem) {
		dao.updateOrderItem(orderItem);
		
	}

	@Override
	public boolean isOrderItemExist(String itemName) {
		return dao.isOrderItemExist(itemName);
	}

}
