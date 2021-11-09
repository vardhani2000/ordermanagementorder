package com.orderManagement.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.orderManagement.DTO.BuyerDTO;
import com.orderManagement.DTO.CartDTO;
import com.orderManagement.DTO.OrderDTO;
import com.orderManagement.DTO.ProductDTO;
import com.orderManagement.entity.Order;
import com.orderManagement.exception.InfyUserException;
import com.orderManagement.service.OrderService;

@RestController
@CrossOrigin
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	
	@RequestMapping(value="/order/placeOrder/{buyerId}",method=RequestMethod.POST)
	public String placeOrder(@PathVariable String buyerId,@RequestBody OrderDTO orderdto) {
		
		ObjectMapper obj=new ObjectMapper();
		BuyerDTO buyerdto=new RestTemplate().getForObject("http://localhost:9100/buyer/"+buyerId,BuyerDTO.class);
		List<ProductDTO> prod=new ArrayList<>();
		List<CartDTO> cart=obj.convertValue(new RestTemplate().getForObject("http://localhost:9100/cart/get/"+buyerId,List.class),
				new TypeReference<List<CartDTO>>(){});
		cart.forEach(item -> {
			ProductDTO p=new RestTemplate().getForObject("http://localhost:9200/product/"+item.getProductId(),ProductDTO.class);
			prod.add(p);
		});
		
		Order p=orderService.placeOrder(prod,cart,orderdto,buyerdto);
		
		cart.forEach(item -> {
			//new RestTemplate().postForObject("http://localhost:9200/products/sellers/update/"+item.getQuantity(),null,String.class) ;
			new RestTemplate().delete("http://localhost:9100/cart/remove/"+buyerId+"/"+item.getProductId());

		});
		
		Integer s=(int)p.getAmount()/100;
		new RestTemplate().getForObject("http://localhost:9100/buyer/updateRewardPoints/"+buyerId+"/"+s, String.class);
		
		if(p!=null) {
			return "Order is placed";
		}
		
		else {
			return "Bad request";
		}
	}
	
	
	@RequestMapping(value = "/order/buyerId/{buyerId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<OrderDTO> getOrderDetailsBasedonBuyer(@PathVariable String buyerId) {
		return orderService.getOrderDetailsBasedonBuyer(buyerId);
	}
	
	@RequestMapping(value = "/order/{orderId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderDTO getOrderDetails(@PathVariable String orderId) {
		return orderService.getOrderDetails(orderId);
	}
	
	@DeleteMapping(value="/order/{orderId}")
	public String updateStatus(@PathVariable String orderId) {
		try {
			orderService.updateStatus(orderId);
		} catch (InfyUserException e) {
			// TODO Auto-generated catch block
			return "Status not updated";
		}
		return "Status updated successfully";
	}

}
