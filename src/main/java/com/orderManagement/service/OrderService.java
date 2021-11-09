package com.orderManagement.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.DTO.BuyerDTO;
import com.orderManagement.DTO.CartDTO;
import com.orderManagement.DTO.IsPrivileged;
import com.orderManagement.DTO.OrderDTO;
import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.DTO.Status;
import com.orderManagement.entity.Order;
import com.orderManagement.entity.OrderId;
import com.orderManagement.entity.ProductsOrdered;
import com.orderManagement.exception.InfyUserException;

import com.orderManagement.repository.OrderRepository;
import com.orderManagement.repository.ProductsOrderedRepository;

@Service
@Transactional
public class OrderService {
	
	static int index=100;
	
	static int shippingCost=99;
	
	@Autowired
	OrderRepository orderRepo;
	
	
	
	@Autowired
	ProductsOrderedRepository poRepo;

	public Order placeOrder(List<ProductDTO> prod,List<CartDTO> cart,OrderDTO orderdto,BuyerDTO buyerdto) {
		
		Order order=new Order();
		String st="O"+ index++;
		order.setOrderId(st);
		order.setBuyerId(cart.get(0).getBuyerId());
		order.setAddress(orderdto.getAddress());
		order.setDate(LocalDate.now());
		order.setStatus(Status.PLACED);
		order.setAmount(0f);
		
		List<ProductsOrdered> s=new ArrayList<>();
		for(int i=0;i<cart.size();i++) {
			if(cart.get(i).getQuantity()<=prod.get(i).getStock()) {
				if(buyerdto.getIsPrivileged()==IsPrivileged.False) {
			order.setAmount(order.getAmount()+(cart.get(i).getQuantity()*prod.get(i).getPrice())+shippingCost);
				}
				else {
					order.setAmount(order.getAmount()+(cart.get(i).getQuantity()*prod.get(i).getPrice()));
				}
			ProductsOrdered produ=new ProductsOrdered();
			produ.setSellerId(prod.get(i).getSeller_id());
			produ.setOrderId(new OrderId(cart.get(i).getBuyerId(),prod.get(i).getProductId()));
			produ.setQuantity(cart.get(i).getQuantity());
			s.add(produ);
		}
		}
		poRepo.saveAll(s);
		orderRepo.save(order);
		
		
		
		return order;
	}
	
	public OrderDTO getOrderDetails(String orderId) {
		Order order=orderRepo.findById(orderId).get();
		OrderDTO orderdto=OrderDTO.valueOf(order);
		return orderdto;
	}
	
	public List<OrderDTO> getOrderDetailsBasedonBuyer(String buyerId) {
		List<Order> order=orderRepo.findByBuyerId(buyerId);
		List<OrderDTO> orderdto=new ArrayList<>();
		order.forEach(o->{
			OrderDTO od=OrderDTO.valueOf(o);
			orderdto.add(od);
		});
		return orderdto;
	}
	
	
	
	public boolean updateStatus(String orderId) throws InfyUserException {
		Optional<Order> op=orderRepo.findById(orderId);
		Order order=op.orElseThrow(()-> new InfyUserException("Order Not Found"));
		order.setStatus(Status.INTRANSIT);
		return true;
	}
	
	public String reOrder(String buyerId, String orderId) throws InfyUserException {
		Optional<Order> optional = orderRepo.findById(orderId);
		Order order = optional.orElseThrow(()->new InfyUserException("Order does not exist for the given buyer"));
		Order reorder = new Order();
		String id = "O" + index++;
		reorder.setOrderId(id);
		reorder.setBuyerId(order.getBuyerId());
		reorder.setAmount(order.getAmount());
		reorder.setAddress(order.getAddress());
		reorder.setDate(LocalDate.now());
		reorder.setStatus(order.getStatus());
		
		orderRepo.save(reorder);		
		return reorder.getOrderId();
	}

	
	
	
	
}
