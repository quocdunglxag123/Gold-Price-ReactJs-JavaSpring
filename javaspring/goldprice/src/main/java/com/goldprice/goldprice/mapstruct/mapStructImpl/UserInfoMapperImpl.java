package com.goldprice.goldprice.mapstruct.mapStructImpl;

import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.RegisterDto;
import com.goldprice.goldprice.entity.UserInfoEntity;
import com.goldprice.goldprice.mapstruct.UserInfoMapper;

@Component
public class UserInfoMapperImpl implements UserInfoMapper{

//	@Override
//	public RegisterDto userInfoEntityToRegisterDto(UserInfoEntity userInfoEntity) {
//		RegisterDto registerDto = new RegisterDto();
//		registerDto.setAddress(userInfoEntity.getAddress());
//		registerDto.setBirthday(userInfoEntity.getBirthday());
//		registerDto.setFullName(userInfoEntity.getFullName());
//		registerDto.setPhoneNumber(userInfoEntity.getPhoneNumber());
//		return registerDto;
//	}

	@Override
	public UserInfoEntity registerDtoToUserInfoEntity(RegisterDto registerDto) {
		UserInfoEntity userInfoEntity = new UserInfoEntity();
		userInfoEntity.setAddress(registerDto.getAddress());
		userInfoEntity.setBirthday(registerDto.getBirthday());
		userInfoEntity.setFirstName(registerDto.getFirstName());
		userInfoEntity.setLastName(registerDto.getLastName());
		userInfoEntity.setPhoneNumber(registerDto.getPhoneNumber());
		return userInfoEntity;
	}
	
}
