package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class ItemOrder {
	@Id
	@GeneratedValue(generator="itemOrder",strategy=GenerationType.SEQUENCE)
	@SequenceGenerator(name="itemOrder",sequenceName="itemOrder_seq")
	@Column(name="item_Order_id")
	private int orderId;
	@Column(name="item_Id")
	private int itemId;
	@Column(name="item_Name")
	private String itemName;
	@Column(name="item_Brand")
	private String itemBrand;
	@Column(name="Price")
	private int price;
	@Column(name="quantity")
	private int quantity;
	@Column(name="Total")
	private int total;
	@Column(name="item_Status")
	private String itemStatus;
	@Column(name="Cons_Id")
	private int consId;
	public ItemOrder() {
		super();
	}
	public ItemOrder(int orderId) {
		super();
		this.orderId = orderId;
	}
	public ItemOrder(int orderId, int itemId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
	}
	public ItemOrder(int orderId, int itemId, String itemName) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand, int price) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand, int price, int quantity) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand, int price, int quantity, int total) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand, int price, int quantity, int total,
			String itemStatus) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.itemStatus = itemStatus;
	}
	public ItemOrder(int orderId, int itemId, String itemName, String itemBrand, int price, int quantity, int total,
			String itemStatus, int consId) {
		super();
		this.orderId = orderId;
		this.itemId = itemId;
		this.itemName = itemName;
		this.itemBrand = itemBrand;
		this.price = price;
		this.quantity = quantity;
		this.total = total;
		this.itemStatus = itemStatus;
		this.consId = consId;
	}
	@Override
	public String toString() {
		return "ItemOrder [orderId=" + orderId + ", itemId=" + itemId + ", itemName=" + itemName + ", itemBrand="
				+ itemBrand + ", price=" + price + ", quantity=" + quantity + ", total=" + total + ", itemStatus="
				+ itemStatus + ", consId=" + consId + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + consId;
		result = prime * result + ((itemBrand == null) ? 0 : itemBrand.hashCode());
		result = prime * result + itemId;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + orderId;
		result = prime * result + price;
		result = prime * result + quantity;
		result = prime * result + total;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ItemOrder other = (ItemOrder) obj;
		if (consId != other.consId)
			return false;
		if (itemBrand == null) {
			if (other.itemBrand != null)
				return false;
		} else if (!itemBrand.equals(other.itemBrand))
			return false;
		if (itemId != other.itemId)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		if (orderId != other.orderId)
			return false;
		if (price != other.price)
			return false;
		if (quantity != other.quantity)
			return false;
		if (total != other.total)
			return false;
		return true;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemBrand() {
		return itemBrand;
	}
	public void setItemBrand(String itemBrand) {
		this.itemBrand = itemBrand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public String getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}
	public int getConsId() {
		return consId;
	}
	public void setConsId(int consId) {
		this.consId = consId;
	}
	
}
