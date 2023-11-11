package com.goldprice.goldprice.dto;

public class OrderDto extends BaseDto {
	private AccountDto accountDto;

	private double totalAmount;

	private Boolean paymentStatus;

	private String shippingAddress;

	public OrderDto() {
		super();
	}

	public OrderDto(AccountDto accountDto, double totalAmount, Boolean paymentStatus, String shippingAddress) {
		super();
		this.accountDto = accountDto;
		this.totalAmount = totalAmount;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
	}

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Boolean getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(Boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

}
