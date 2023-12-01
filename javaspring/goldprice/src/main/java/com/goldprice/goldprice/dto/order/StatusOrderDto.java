package com.goldprice.goldprice.dto.order;

import com.goldprice.goldprice.dto.BaseDto;

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
