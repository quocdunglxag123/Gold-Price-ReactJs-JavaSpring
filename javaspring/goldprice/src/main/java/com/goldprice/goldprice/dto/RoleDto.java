package com.goldprice.goldprice.dto;

public class RoleDto extends BaseDto {
	private String name;

	
	public RoleDto() {
		super();
	}

	public RoleDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name.toLowerCase();
	}

}
