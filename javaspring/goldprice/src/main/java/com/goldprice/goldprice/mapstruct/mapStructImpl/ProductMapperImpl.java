package com.goldprice.goldprice.mapstruct.mapStructImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.goldprice.goldprice.dto.product.ProductDto;
import com.goldprice.goldprice.entity.product.ProductEntity;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.mapstruct.ProductMapper;

@Component
public class ProductMapperImpl implements ProductMapper {

	@Autowired
	GenerateMapper generateMapper;

	@Override
	public ProductDto productEntityToProductDto(ProductEntity productEntity) {
		if (productEntity == null) {
			return null;
		}

		ProductDto productDto = new ProductDto();

		productDto.setId(productEntity.getId());
		productDto.setUpdateDate(productEntity.getUpdateDate());
		productDto.setCreateDate(productEntity.getCreateDate());
		productDto.setName(productEntity.getName());
		productDto.setProductPurityDto(
				generateMapper.productPurityEntityToProductPurityDto(productEntity.getProductPurityEntity()));
		productDto.setProductMaterialDto(
				generateMapper.productMaterialEntityToProductMaterialDto(productEntity.getProductMaterialEntity()));
		productDto.setProductTypeDto(
				generateMapper.productTypeEntityToProductTypeDto(productEntity.getProductTypeEntity()));
		productDto.setDescription(productEntity.getDescription());
		productDto.setWeight(productEntity.getWeight());
		productDto.setPrice(productEntity.getPrice());
		productDto.setInStock(productEntity.getInStock());
		productDto.setProductImgDtos(
				generateMapper.listProductImgEntityToListProductImgDto(productEntity.getProductImgEntities())
		);

		return productDto;
	}

	@Override
	public List<ProductDto> listProductEntityToListProductDto(List<ProductEntity> productEntities) {
		if (productEntities == null) {
			return null;
		}

		List<ProductDto> list = new ArrayList<ProductDto>(productEntities.size());
		for (ProductEntity productEntity : productEntities) {
			list.add(productEntityToProductDto(productEntity));
		}

		return list;
	}

	@Override
	public ProductEntity productDtoToProductEntity(ProductDto productDto) {
		if (productDto == null) {
			return null;
		}

		ProductEntity productEntity = new ProductEntity();

		productEntity.setId(productDto.getId());
		productEntity.setUpdateDate(productDto.getUpdateDate());
		productEntity.setCreateDate(productDto.getCreateDate());
		productEntity.setName(productDto.getName());
		productEntity.setProductPurityEntity(
				generateMapper.productPurityDtoToProductPurityEntity(productDto.getProductPurityDto()));
		productEntity.setProductMaterialEntity(
				generateMapper.productMaterialDtoToProductMaterialEntity(productDto.getProductMaterialDto()));
		productEntity
				.setProductTypeEntity(generateMapper.productTypeDtoToProductTypeEntity(productDto.getProductTypeDto()));
		productEntity.setDescription(productDto.getDescription());
		productEntity.setWeight(productDto.getWeight());
		productEntity.setPrice(productDto.getPrice());
		productEntity.setInStock(productDto.getInStock());
		productEntity.setProductImgEntities(
				generateMapper.listProductImgDtoToListProductImgEntity(productDto.getProductImgDtos())
		);

		return productEntity;
	}

	@Override
	public List<ProductEntity> listProductDtoToListProductEntity(List<ProductDto> productDtos) {
		if (productDtos == null) {
			return null;
		}

		List<ProductEntity> list = new ArrayList<ProductEntity>(productDtos.size());
		for (ProductDto productDto : productDtos) {
			list.add(productDtoToProductEntity(productDto));
		}

		return list;
	}
}
