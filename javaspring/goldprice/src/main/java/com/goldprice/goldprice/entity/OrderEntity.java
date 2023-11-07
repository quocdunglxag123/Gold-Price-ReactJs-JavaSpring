package com.goldprice.goldprice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderEntity  extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "userInfoId")
	private UserInfoEntity userInfoEntity;

	private Date orderDate;

	private double totalAmount;

	private Boolean paymentStatus;

	private String shippingAddress;

	public OrderEntity() {
		super();
	}

	public OrderEntity(UserInfoEntity userInfoEntity, Date orderDate, double totalAmount, Boolean paymentStatus,
			String shippingAddress) {
		super();
		this.userInfoEntity = userInfoEntity;
		this.orderDate = orderDate;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
	}

	public UserInfoEntity getUserInfoEntity() {
		return userInfoEntity;
	}

	public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
		this.userInfoEntity = userInfoEntity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
