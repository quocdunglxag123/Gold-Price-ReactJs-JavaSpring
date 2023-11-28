package com.goldprice.goldprice.dto;

public class ProductPurityDto extends BaseDto {
	private String name;

	public ProductPurityDto() {
		super();
	}

	public ProductPurityDto(String name) {
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
