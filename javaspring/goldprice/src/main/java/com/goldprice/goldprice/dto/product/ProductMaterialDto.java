package com.goldprice.goldprice.dto.product;

import com.goldprice.goldprice.dto.BaseDto;

public class ProductMaterialDto extends BaseDto {
	private String name;

	public ProductMaterialDto() {
		super();
	}

	public ProductMaterialDto(String name) {
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
