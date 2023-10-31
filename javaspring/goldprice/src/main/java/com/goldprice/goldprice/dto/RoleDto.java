package com.goldprice.goldprice.dto;

public class RoleDto extends BaseDto {
	private String roleName;

	
	public RoleDto() {
		super();
	}

	public RoleDto(String roleName) {
		super();
		this.roleName = roleName;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName.toLowerCase();
	}

}
