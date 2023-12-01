package com.goldprice.goldprice.entity.order;

import java.math.BigDecimal;

import com.goldprice.goldprice.entity.BaseEntity;
import com.goldprice.goldprice.entity.product.ProductEntity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrderItem")
public class OrderItemEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "orderId")
	private OrderEntity orderEntity;

	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductEntity productEntity;

	private int quantity;
	private BigDecimal subTotal;

	public OrderItemEntity() {
		super();
	}

	public OrderItemEntity(OrderEntity orderEntity, ProductEntity productEntity, int quantity, BigDecimal subTotal) {
		super();
		this.orderEntity = orderEntity;
		this.productEntity = productEntity;
		this.quantity = quantity;
		this.subTotal = subTotal;
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

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

}