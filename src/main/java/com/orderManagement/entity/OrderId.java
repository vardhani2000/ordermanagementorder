package com.orderManagement.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@SuppressWarnings("serial")
@Embeddable
public class OrderId implements Serializable {
	
	String buyerId;
	String productId;
	
	public OrderId() {}
	
	public OrderId(String buyerId, String productId) {
		this.buyerId = buyerId;
		this.productId = productId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(buyerId, productId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderId other = (OrderId) obj;
		return Objects.equals(buyerId, other.buyerId) && Objects.equals(productId, other.productId);
	}
	
	
	
	
	
}
