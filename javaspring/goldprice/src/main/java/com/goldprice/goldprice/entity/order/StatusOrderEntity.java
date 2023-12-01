package com.goldprice.goldprice.entity.order;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "StatusOrder")
public class StatusOrderEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

    @OneToOne(mappedBy = "statusOrderEntity")
	private OrderEntity orderEntity;

	public StatusOrderEntity() {
		super();
	}

	public StatusOrderEntity(String name, OrderEntity orderEntity) {
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
