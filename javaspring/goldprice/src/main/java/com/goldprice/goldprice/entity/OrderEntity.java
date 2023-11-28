package com.goldprice.goldprice.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "accountId")
	private AccountEntity accountEntity;

	@OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL)
	private List<OrderItemEntity> orderItemEntities;

	private BigDecimal totalAmount;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "statusOrderId", referencedColumnName = "id")
	private StatusOrderEntity statusOrderEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "paymentOrderId", referencedColumnName = "id")
	private PaymentOrderEntity paymentOrderEntity;

	private String shippingAddress;

	public OrderEntity() {
		super();
	}

	public OrderEntity(AccountEntity accountEntity, List<OrderItemEntity> orderItemEntities, BigDecimal totalAmount,
			StatusOrderEntity statusOrderEntity, PaymentOrderEntity paymentOrderEntity, String shippingAddress) {
		super();
		this.accountEntity = accountEntity;
		this.orderItemEntities = orderItemEntities;
		this.totalAmount = totalAmount;
		this.statusOrderEntity = statusOrderEntity;
		this.paymentOrderEntity = paymentOrderEntity;
		this.shippingAddress = shippingAddress;
	}

	public AccountEntity getAccountEntity() {
		return accountEntity;
	}

	public void setAccountEntity(AccountEntity accountEntity) {
		this.accountEntity = accountEntity;
	}

	public List<OrderItemEntity> getOrderItemEntities() {
		return orderItemEntities;
	}

	public void setOrderItemEntities(List<OrderItemEntity> orderItemEntities) {
		this.orderItemEntities = orderItemEntities;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public StatusOrderEntity getStatusOrderEntity() {
		return statusOrderEntity;
	}

	public void setStatusOrderEntity(StatusOrderEntity statusOrderEntity) {
		this.statusOrderEntity = statusOrderEntity;
	}

	public PaymentOrderEntity getPaymentOrderEntity() {
		return paymentOrderEntity;
	}

	public void setPaymentOrderEntity(PaymentOrderEntity paymentOrderEntity) {
		this.paymentOrderEntity = paymentOrderEntity;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
