package com.goldprice.goldprice.mapstruct;

import com.goldprice.goldprice.dto.account.RegisterDto;
import com.goldprice.goldprice.entity.account.UserInfoEntity;


public interface UserInfoMapper {
	// ----------------------------Entity To DTO---------------------------

//	RegisterDto accountEntityToRegisterDto(AccountEntity accountEntity);
	

	// ---------------------------DTO To Entity----------------------

	UserInfoEntity registerDtoToUserInfoEntity(RegisterDto registerDto);	
	
}