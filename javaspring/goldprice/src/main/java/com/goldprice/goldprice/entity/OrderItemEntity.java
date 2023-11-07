package com.goldprice.goldprice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItems")
public class OrderItemEntity  extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderEntity orderEntity;

	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductEntity productEntity;

	private int quantity;

	private double subtotal;

	public OrderItemEntity() {
		super();
	}

	public OrderItemEntity(OrderEntity orderEntity, ProductEntity productEntity, int quantity, double subtotal) {
		super();
		this.orderEntity = orderEntity;
		this.productEntity = productEntity;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public OrderEntity getOrderEntity() {
		return orderEntity;
	}

	public void setOrderEntity(OrderEntity orderEntity) {
		this.orderEntity = orderEntity;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

}