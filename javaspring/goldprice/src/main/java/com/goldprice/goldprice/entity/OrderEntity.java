package com.goldprice.goldprice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "accountId")
	private AccountEntity accountEntity;

	private double totalAmount;

	private Boolean paymentStatus;

	private String shippingAddress;

	public OrderEntity() {
		super();
	}

	public OrderEntity(AccountEntity accountEntity, double totalAmount, Boolean paymentStatus, String shippingAddress) {
		super();
		this.accountEntity = accountEntity;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
	}

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
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
