package com.orderManagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.Order;

public interface OrderRepository extends JpaRepository<Order,String>{

	public List<Order> findByBuyerId(String buyerId);
}
