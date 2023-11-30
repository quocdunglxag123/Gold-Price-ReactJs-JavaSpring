package com.goldprice.goldprice.dto;

public class PaymentOrderDto extends BaseDto {
	private String name;

	public PaymentOrderDto() {
		super();
	}

	public PaymentOrderDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
