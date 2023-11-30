package com.goldprice.goldprice.dto;

public class StatusOrderDto extends BaseDto {
	private String name;

	public StatusOrderDto() {
		super();
	}

	public StatusOrderDto(String name) {
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
