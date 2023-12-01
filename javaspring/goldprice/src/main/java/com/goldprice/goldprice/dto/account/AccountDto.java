package com.goldprice.goldprice.dto.account;

import java.util.List;

import com.goldprice.goldprice.dto.BaseDto;

public class AccountDto extends BaseDto {
	private String username;
	private String password;
	private List<RoleDto> roleDtos;
	
	public AccountDto() {
		super();
	}

	public AccountDto(String username, String password, List<RoleDto> roleDtos) {
		super();
		this.username = username;
		this.password = password;
		this.roleDtos = roleDtos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<RoleDto> getRoleDtos() {
		return roleDtos;
	}

	public void setRoleDtos(List<RoleDto> roleDtos) {
		this.roleDtos = roleDtos;
	}

	
}
