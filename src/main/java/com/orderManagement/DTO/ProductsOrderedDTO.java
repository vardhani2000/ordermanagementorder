package com.orderManagement.DTO;



public class ProductsOrderedDTO {
	
	String buyerId;
	String productId;
	String sellerId;
	Integer quantity;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
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
		return "ProductsOrderedDTO [buyerId=" + buyerId + ", productId=" + productId + ", sellerId=" + sellerId
				+ ", quantity=" + quantity + "]";
	}
	public ProductsOrderedDTO(String buyerId, String productId, String sellerId, Integer quantity) {
		super();
		this.buyerId = buyerId;
		this.productId = productId;
		this.sellerId = sellerId;
		this.quantity = quantity;
	}
	
	public ProductsOrderedDTO() {}
	
}
