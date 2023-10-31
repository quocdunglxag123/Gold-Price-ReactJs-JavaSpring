package com.goldprice.goldprice.mapstruct;

import com.goldprice.goldprice.dto.RegisterDto;
import com.goldprice.goldprice.entity.UserInfoEntity;


public interface UserInfoMapper {
	// ----------------------------Entity To DTO---------------------------

//	RegisterDto accountEntityToRegisterDto(AccountEntity accountEntity);
	

	// ---------------------------DTO To Entity----------------------

	UserInfoEntity registerDtoToUserInfoEntity(RegisterDto registerDto);	
	
}