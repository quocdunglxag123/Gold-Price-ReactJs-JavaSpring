package com.goldprice.goldprice.mapstruct;

import java.util.List;

import com.goldprice.goldprice.dto.product.ProductDto;
import com.goldprice.goldprice.entity.product.ProductEntity;

public interface ProductMapper {
	// ----------------------------Product Start---------------------------
	// Entity To DTO
	ProductDto productEntityToProductDto(ProductEntity productEntity);

	List<ProductDto> listProductEntityToListProductDto(List<ProductEntity> productEntities);

	// DTO To Entity
	ProductEntity productDtoToProductEntity(ProductDto productDto);

	List<ProductEntity> listProductDtoToListProductEntity(List<ProductDto> productDtos);
	// ----------------------------Product End---------------------------

}
