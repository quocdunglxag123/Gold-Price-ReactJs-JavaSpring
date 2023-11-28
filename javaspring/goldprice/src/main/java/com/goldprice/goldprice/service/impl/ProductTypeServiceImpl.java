package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.ProductTypeDto;
import com.goldprice.goldprice.entity.ProductTypeEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.ProductTypeRepository;
import com.goldprice.goldprice.service.ProductTypeService;

@Service
public class ProductTypeServiceImpl implements ProductTypeService {

	@Autowired
	private ProductTypeRepository productTypeRepository;
	@Autowired
	private GenerateMapper productTypeMapper;

	/**
	 * Get ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to get
	 * 
	 * @return productTypeDto Object contains information about an productType in database
	 */
	@Override
	public Object getProductType(ProductTypeDto productTypeDto) {
		return productTypeMapper.productTypeEntityToProductTypeDto(productTypeRepository.findOneById(productTypeDto.getId()));
	}

	/**
	 * Get All ProductType
	 * 
	 * @return productTypeDto Object contains all information about productType in database
	 */
	@Override
	public Object getAllProductType() {
		return productTypeMapper.listProductTypeEntityToListProductTypeDto(productTypeRepository.findAll());
	}

	/**
	 * Add ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addProductType(ProductTypeDto productTypeDto) {
		ProductTypeEntity productTypeEntity = productTypeMapper.productTypeDtoToProductTypeEntity(productTypeDto);
		productTypeRepository.save(productTypeEntity);
		return true;
	}

	/**
	 * Update ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateProductType(ProductTypeDto productTypeDto) {
		ProductTypeEntity productTypeEntityUpdate = productTypeRepository.findOneById(productTypeDto.getId());
		if (productTypeEntityUpdate != null) {
			// Case: ProductType is in database
			productTypeEntityUpdate.setName(productTypeDto.getName());
			productTypeRepository.save(productTypeEntityUpdate);
			return true;
		} else {
			throw new ProductException("ProductType Not Found!");
		}
	}

	/**
	 * Delete ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteProductType(ProductTypeDto productTypeDto) {
		productTypeRepository.deleteById(productTypeDto.getId());
		return true;
	}

}
