package com.goldprice.goldprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StatusOrder")
public class StatusOrderEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String statusOrderName;

	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderEntity orderEntity;

	public StatusOrderEntity() {
		super();
	}

	public StatusOrderEntity(String statusOrderName, OrderEntity orderEntity) {
		super();
		this.statusOrderName = statusOrderName;
		this.orderEntity = orderEntity;
	}

	public String getStatusOrderName() {
		return statusOrderName;
	}

	public void setStatusOrderName(String statusOrderName) {
		this.statusOrderName = statusOrderName;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

}
