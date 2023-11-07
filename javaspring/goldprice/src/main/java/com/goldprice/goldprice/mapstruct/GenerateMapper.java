package com.goldprice.goldprice.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.goldprice.goldprice.dto.ProductDto;
import com.goldprice.goldprice.dto.RoleDto;
import com.goldprice.goldprice.dto.UserInfoDto;
import com.goldprice.goldprice.entity.ProductEntity;
import com.goldprice.goldprice.entity.RoleEntity;
import com.goldprice.goldprice.entity.UserInfoEntity;

@Mapper(componentModel = "spring")
public interface GenerateMapper {
	
	// ----------------------------Role Start---------------------------
	//Entity To DTO
	RoleDto roleEntityToRoleDto(RoleEntity roleEntity);
	List<RoleDto> listRoleEntityToListRoleDto(List<RoleEntity> roleEntities);
	
	//DTO To Entity
	RoleEntity roleDtoToRoleEntity(RoleDto roleDto);	
	List<RoleEntity> listRoleDtoToListRoleEntity(List<RoleDto> roleDtos);	
	// ----------------------------Role End---------------------------

	
	// ----------------------------UserInfo Start---------------------------
	//Entity To DTO
	UserInfoDto userInfoEntityToUserInfoDto(UserInfoEntity userInfoEntity);
	List<UserInfoDto> listUserInfoEntityToListUserInfoDto(List<UserInfoEntity> userInfoEntities);

	//DTO To Entity
	UserInfoEntity userInfoDtoToUserInfoEntity(UserInfoDto userInfoDto);	
	// ----------------------------UserInfo End---------------------------

	// ----------------------------Product Start---------------------------
	//Entity To DTO
	ProductDto productEntityToProductDto(ProductEntity productEntity);
	List<ProductDto> listProductEntityToListProductDto(List<ProductEntity> productEntities);
	
	//DTO To Entity
	ProductEntity productDtoToProductEntity(ProductDto productDto);	
	List<ProductEntity> listProductDtoToListProductEntity(List<ProductDto> productDtos);	
	// ----------------------------Product End---------------------------


	
	
}