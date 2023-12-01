package com.goldprice.goldprice.dto.account;

public class LoginDto {
	private AccountDto accountDto;
	private TokenDto tokenDto;
	private UserInfoDto userInfoDto;

	public LoginDto() {
		super();
	}

	public LoginDto(AccountDto accountDto, TokenDto tokenDto, UserInfoDto userInfoDto) {
		super();
		this.accountDto = accountDto;
		this.tokenDto = tokenDto;
		this.userInfoDto = userInfoDto;
	}

	public UserInfoDto getUserInfoDto() {
		return userInfoDto;
	}

	public void setUserInfoDto(UserInfoDto userInfoDto) {
		this.userInfoDto = userInfoDto;
	}

	public AccountDto getAccountDto() {
		return accountDto;
	}

	public void setAccountDto(AccountDto accountDto) {
		this.accountDto = accountDto;
	}

	public TokenDto getTokenDto() {
		return tokenDto;
	}

	public void setTokenDto(TokenDto tokenDto) {
		this.tokenDto = tokenDto;
	}

}
