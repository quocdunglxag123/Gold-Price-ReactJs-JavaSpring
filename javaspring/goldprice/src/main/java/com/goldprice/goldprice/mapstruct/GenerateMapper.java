package com.goldprice.goldprice.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.goldprice.goldprice.dto.RoleDto;
import com.goldprice.goldprice.dto.UserInfoDto;
import com.goldprice.goldprice.entity.RoleEntity;
import com.goldprice.goldprice.entity.UserInfoEntity;

@Mapper(componentModel = "spring")
public interface GenerateMapper {
	
	// ----------------------------Entity To DTO---------------------------

	//Role
	RoleDto roleEntityToRoleDto(RoleEntity roleEntity);
	List<RoleDto> listRoleEntityToListRoleDto(List<RoleEntity> roleEntities);
	
	
	//UserInfo
	UserInfoDto userInfoEntityToUserInfoDto(UserInfoEntity userInfoEntity);
	List<UserInfoDto> listUserInfoEntityToListUserInfoDto(List<UserInfoEntity> userInfoEntities);

	// ---------------------------DTO To Entity----------------------

	//Role
	RoleEntity roleDtoToRoleEntity(RoleDto roleDto);	
	List<RoleEntity> listRoleDtoToListRoleEntity(List<RoleDto> roleDtos);	
	
	
	//UserInfo
	UserInfoEntity userInfoDtoToUserInfoEntity(UserInfoDto userInfoDto);	
}