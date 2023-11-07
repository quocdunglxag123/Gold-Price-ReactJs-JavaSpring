package com.goldprice.goldprice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TransactionProduct")
public class TransactionProductEntity extends BaseEntity {

	@ManyToOne
	@JoinColumn(name = "userInfoId")
	private UserInfoEntity userInfoEntity;

	private Date transactionDate;

	private String transactionType;

	private double amount;

	public TransactionProductEntity() {
		super();
	}

	public TransactionProductEntity(UserInfoEntity userInfoEntity, Date transactionDate, String transactionType,
			double amount) {
		super();
		this.userInfoEntity = userInfoEntity;
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.amount = amount;
	}

	public UserInfoEntity getUserInfoEntity() {
		return userInfoEntity;
	}

	public void setUserInfoEntity(UserInfoEntity userInfoEntity) {
		this.userInfoEntity = userInfoEntity;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}