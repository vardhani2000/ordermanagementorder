package com.orderManagement.DTO;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class BuyerDTO {
	@Column(unique=true)
	String buyerId;
	@NotNull(message = "{buyer.name.absent}")
    @Pattern(regexp="[A-Za-z]+( [A-Za-z]+)*", message="{buyer.name.invalid}")
	String name;
	@Email(message = "{buyer.email.invalid}")
    @NotNull(message = "{buyer.email.absent}")
	String email;
	@Pattern(regexp="^[6-9]{1}[0-9]{9}$", message="{buyer.phone.invalid}")
	String phone;
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$#^!%*&])[A-Za-z\\d@$#^!%*&]{7,20}$", 
			message="{buyer.password.invalid}")
	String password;
	IsPrivileged isprivileged;
	Integer rewardPoints;
	IsActive isactive;
	
	
	public String getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(String buyerId) {
		this.buyerId = buyerId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNo() {
		return phone;
	}
	public void setPhoneNo(String phoneNo) {
		this.phone = phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public IsPrivileged getIsPrivileged() {
		return isprivileged;
	}
	public void setIsPrivileged(IsPrivileged isPrivileged) {
		this.isprivileged = isPrivileged;
	}
	public Integer getRewardPoints() {
		return rewardPoints;
	}
	public void setRewardPoints(Integer rewardPoints) {
		this.rewardPoints = rewardPoints;
	}
	public IsActive getIsActive() {
		return isactive;
	}
	public void setIsActive(IsActive isActive) {
		this.isactive = isActive;
	}
}