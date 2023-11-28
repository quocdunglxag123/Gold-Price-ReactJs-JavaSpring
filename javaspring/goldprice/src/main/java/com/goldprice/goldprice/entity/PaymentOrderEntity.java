package com.goldprice.goldprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaymentOrder")
public class PaymentOrderEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

    @OneToOne(mappedBy = "paymentOrderEntity")
	private OrderEntity orderEntity;

	public PaymentOrderEntity() {
		super();
	}

	public PaymentOrderEntity(String name, OrderEntity orderEntity) {
		super();
		this.name = name;
		this.orderEntity = orderEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

}
