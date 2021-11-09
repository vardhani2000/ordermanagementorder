package com.orderManagement.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
public class ProductsOrdered {
	
	@EmbeddedId
	OrderId orderId;
	String sellerId;
	Integer quantity;
	
	
	
	public OrderId getOrderId() {
		return orderId;
	}
	public void setOrderId(OrderId orderId) {
		this.orderId = orderId;
	}
	public ProductsOrdered(OrderId orderId, String sellerId, Integer quantity) {
		super();
		this.orderId = orderId;
		this.sellerId = sellerId;
		this.quantity = quantity;
	}
	
	public ProductsOrdered() {}
	
	public String getSellerId() {
		return sellerId;
	}
	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	@Override
	public String toString() {
		return "ProductsOrdered [orderId=" + orderId + ", sellerId=" + sellerId + ", quantity=" + quantity + "]";
	}
	

}
