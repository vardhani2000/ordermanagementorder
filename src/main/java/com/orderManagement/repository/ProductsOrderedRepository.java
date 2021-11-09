package com.orderManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.entity.OrderId;
import com.orderManagement.entity.ProductsOrdered;

public interface ProductsOrderedRepository extends JpaRepository<ProductsOrdered,OrderId>{

}
