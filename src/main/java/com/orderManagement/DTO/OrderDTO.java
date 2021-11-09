package com.orderManagement.DTO;

import java.time.LocalDate;
import java.util.Date;

import javax.validation.constraints.Pattern;

import com.orderManagement.entity.Order;

public class OrderDTO {
	
	String orderId;
	String buyerId;
	float amount;
	LocalDate date;
	@Pattern(regexp="^.{10,50}",message= "{order.address.invalid}")
	String address;
	Status status;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public OrderDTO() {}
	public OrderDTO(String orderId, String buyerId, float amount, LocalDate date, String address, Status status) {
		this.orderId = orderId;
		this.buyerId = buyerId;
		this.amount = amount;
		this.date = date;
		this.address = address;
		this.status = status;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", buyerId=" + buyerId + ", amount=" + amount + ", date=" + date
				+ ", address=" + address + ", status=" + status + "]";
	}
	
	public static OrderDTO valueOf(Order order) {
		OrderDTO orderdto=new OrderDTO();
		orderdto.setOrderId(order.getOrderId());
		orderdto.setBuyerId(order.getBuyerId());
		orderdto.setAddress(order.getAddress());
		orderdto.setDate(order.getDate());
		orderdto.setStatus(order.getStatus());
		orderdto.setAmount(order.getAmount());
		return orderdto;
		
	}
	
	public Order createEntity() {
		Order order=new Order();
		order.setAddress(this.address);
		order.setOrderId(this.orderId);
		order.setBuyerId(this.buyerId);
		order.setStatus(Status.PLACED);
		order.setAmount(this.amount);
		order.setDate(this.date);
		return order;
	}
	

}
