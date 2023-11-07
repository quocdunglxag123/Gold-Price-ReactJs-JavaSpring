package com.goldprice.goldprice.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Payments")
public class PaymentEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity orderEntity;

	private Date paymentDate;

	private double paymentAmount;

	public PaymentEntity() {
		super();
	}

	public PaymentEntity(OrderEntity orderEntity, Date paymentDate, double paymentAmount) {
		super();
		this.orderEntity = orderEntity;
		this.paymentDate = paymentDate;
		this.paymentAmount = paymentAmount;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(double paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

}
