package com.orderManagement.DTO;

import javax.persistence.Column;

import com.orderManagement.entity.Cart;



public class CartDTO {

	@Column(name = "buyer_id")
	String buyerId;
	@Column(name = "product_id")
	String productId;
	Integer quantity;
	
	public CartDTO() {}
	
	
	public CartDTO(String buyerId, String productId, Integer quantity) {
		//super();
		this.buyerId = buyerId;
		this.productId = productId;
		this.quantity = quantity;
	}

	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	
	public String getProductId() {
		return productId;
	}


	public void setProductId(String productId) {
		this.productId = productId;
	}


	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public static CartDTO valueOf(Cart cart) {
		CartDTO cartdto=new CartDTO();
		cartdto.setBuyerId(cart.getCartId().getBuyerId());
		cartdto.setProductId(cart.getCartId().getBuyerId());
		cartdto.setQuantity(cart.getQuantity());
		return cartdto;
	}

}
