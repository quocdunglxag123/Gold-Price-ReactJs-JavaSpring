package com.goldprice.goldprice.dto;

import com.goldprice.goldprice.entity.OrderEntity;

public class StatusOrderDto extends BaseDto {
	private String statusOrderName;
	private OrderEntity orderEntity;

	public StatusOrderDto() {
		super();
	}

	public StatusOrderDto(String statusOrderName, OrderEntity orderEntity) {
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
