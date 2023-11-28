package com.goldprice.goldprice.dto;

public class ProductTypeDto extends BaseDto {
	private String name;

	public ProductTypeDto() {
		super();
	}

	public ProductTypeDto(String name) {
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
