package com.goldprice.goldprice.mapstruct;

import java.util.List;

import org.mapstruct.Mapper;

import com.goldprice.goldprice.dto.account.RoleDto;
import com.goldprice.goldprice.dto.account.UserInfoDto;
import com.goldprice.goldprice.dto.order.PaymentOrderDto;
import com.goldprice.goldprice.dto.order.StatusOrderDto;
import com.goldprice.goldprice.dto.product.ProductImgDto;
import com.goldprice.goldprice.dto.product.ProductMaterialDto;
import com.goldprice.goldprice.dto.product.ProductPurityDto;
import com.goldprice.goldprice.dto.product.ProductTypeDto;
import com.goldprice.goldprice.entity.account.RoleEntity;
import com.goldprice.goldprice.entity.account.UserInfoEntity;
import com.goldprice.goldprice.entity.order.PaymentOrderEntity;
import com.goldprice.goldprice.entity.order.StatusOrderEntity;
import com.goldprice.goldprice.entity.product.ProductImgEntity;
import com.goldprice.goldprice.entity.product.ProductMaterialEntity;
import com.goldprice.goldprice.entity.product.ProductPurityEntity;
import com.goldprice.goldprice.entity.product.ProductTypeEntity;

@Mapper(componentModel = "spring")
public interface GenerateMapper {

	// ----------------------------Role Start---------------------------
	// Entity To DTO
	RoleDto roleEntityToRoleDto(RoleEntity roleEntity);

	List<RoleDto> listRoleEntityToListRoleDto(List<RoleEntity> roleEntities);

	// DTO To Entity
	RoleEntity roleDtoToRoleEntity(RoleDto roleDto);

	List<RoleEntity> listRoleDtoToListRoleEntity(List<RoleDto> roleDtos);
	// ----------------------------Role End---------------------------

	// ----------------------------UserInfo Start---------------------------
	// Entity To DTO
	UserInfoDto userInfoEntityToUserInfoDto(UserInfoEntity userInfoEntity);

	List<UserInfoDto> listUserInfoEntityToListUserInfoDto(List<UserInfoEntity> userInfoEntities);

	// DTO To Entity
	UserInfoEntity userInfoDtoToUserInfoEntity(UserInfoDto userInfoDto);
	// ----------------------------UserInfo End---------------------------

	// ----------------------------StatusOrder Start---------------------------
	// Entity To DTO
	StatusOrderDto statusOrderEntityToStatusOrderDto(StatusOrderEntity statusOrderEntity);

	List<StatusOrderDto> listStatusOrderEntityToListStatusOrderDto(List<StatusOrderEntity> statusOrderEntities);

	// DTO To Entity
	StatusOrderEntity statusOrderDtoToStatusOrderEntity(StatusOrderDto statusOrderDto);

	List<StatusOrderEntity> listStatusOrderDtoToListStatusOrderEntity(List<StatusOrderDto> statusOrderDtos);

	// ----------------------------StatusOrder End---------------------------

	// ----------------------------PaymentOrder Start---------------------------
	// Entity To DTO
	PaymentOrderDto paymentOrderEntityToPaymentOrderDto(PaymentOrderEntity paymentOrderEntity);

	List<PaymentOrderDto> listPaymentOrderEntityToListPaymentOrderDto(List<PaymentOrderEntity> statusOrderEntities);

	// DTO To Entity
	PaymentOrderEntity paymentOrderDtoToPaymentOrderEntity(PaymentOrderDto paymentOrderDto);

	List<PaymentOrderEntity> listPaymentOrderDtoToListPaymentOrderEntity(List<PaymentOrderDto> paymentOrderDtos);

	// ----------------------------PaymentOrder End---------------------------

	// ----------------------------ProductPurity Start---------------------------
	// Entity To DTO
	ProductPurityDto productPurityEntityToProductPurityDto(ProductPurityEntity productPurityEntity);

	List<ProductPurityDto> listProductPurityEntityToListProductPurityDto(List<ProductPurityEntity> statusOrderEntities);

	// DTO To Entity
	ProductPurityEntity productPurityDtoToProductPurityEntity(ProductPurityDto productPurityDto);

	List<ProductPurityEntity> listProductPurityDtoToListProductPurityEntity(List<ProductPurityDto> productPurityDtos);

	// ----------------------------ProductPurity End---------------------------

	// ----------------------------ProductType Start---------------------------
	// Entity To DTO
	ProductTypeDto productTypeEntityToProductTypeDto(ProductTypeEntity productTypeEntity);

	List<ProductTypeDto> listProductTypeEntityToListProductTypeDto(List<ProductTypeEntity> statusOrderEntities);

	// DTO To Entity
	ProductTypeEntity productTypeDtoToProductTypeEntity(ProductTypeDto productTypeDto);

	List<ProductTypeEntity> listProductTypeDtoToListProductTypeEntity(List<ProductTypeDto> productTypeDtos);

	// ----------------------------ProductType End---------------------------

	// ----------------------------ProductMaterial Start---------------------------
	// Entity To DTO
	ProductMaterialDto productMaterialEntityToProductMaterialDto(ProductMaterialEntity productMaterialEntity);

	List<ProductMaterialDto> listProductMaterialEntityToListProductMaterialDto(
			List<ProductMaterialEntity> productMaterialEntities);

	// DTO To Entity
	ProductMaterialEntity productMaterialDtoToProductMaterialEntity(ProductMaterialDto productMaterialDto);

	List<ProductMaterialEntity> listProductMaterialDtoToListProductMaterialEntity(
			List<ProductMaterialDto> productMaterialDtos);
	// ----------------------------ProductMaterial End---------------------------

	// ----------------------------ProductImg Start---------------------------
	// Entity To DTO
	ProductImgDto productImgEntityToProductImgDto(ProductImgEntity productImgEntity);

	List<ProductImgDto> listProductImgEntityToListProductImgDto(List<ProductImgEntity> productImgEntities);

	// DTO To Entity
	ProductImgEntity productImgDtoToProductImgEntity(ProductImgDto productImgDto);

	List<ProductImgEntity> listProductImgDtoToListProductImgEntity(List<ProductImgDto> productImgDtos);
	// ----------------------------ProductImg End---------------------------

}