package com.goldprice.goldprice.dto.order;

import java.math.BigDecimal;
import java.util.List;

import com.goldprice.goldprice.dto.BaseDto;
import com.goldprice.goldprice.dto.account.AccountDto;

public class OrderDto extends BaseDto {
	private AccountDto accountDto;

	private List<OrderItemDto> orderItemDtos;

	private BigDecimal totalAmount;

	private StatusOrderDto statusOrderDto;
	
	private PaymentOrderDto paymentOrderDto;

	private String shippingAddress;

	public OrderDto() {
		super();
	}

	public OrderDto(AccountDto accountDto, List<OrderItemDto> orderItemDtos, BigDecimal totalAmount,
			StatusOrderDto statusOrderDto, PaymentOrderDto paymentOrderDto, String shippingAddress) {
		super();
		this.accountDto = accountDto;
		this.orderItemDtos = orderItemDtos;
		this.totalAmount = totalAmount;
		this.statusOrderDto = statusOrderDto;
		this.paymentOrderDto = paymentOrderDto;
		this.shippingAddress = shippingAddress;
	}

	public PaymentOrderDto getPaymentOrderDto() {
		return paymentOrderDto;
	}

	public void setPaymentOrderDto(PaymentOrderDto paymentOrderDto) {
		this.paymentOrderDto = paymentOrderDto;
	}

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	public List<OrderItemDto> getOrderItemDtos() {
		return orderItemDtos;
	}

	public void setOrderItemDtos(List<OrderItemDto> orderItemDtos) {
		this.orderItemDtos = orderItemDtos;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}

	public StatusOrderDto getStatusOrderDto() {
		return statusOrderDto;
	}

	public void setStatusOrderDto(StatusOrderDto statusOrderDto) {
		this.statusOrderDto = statusOrderDto;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
