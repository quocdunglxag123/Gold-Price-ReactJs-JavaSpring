package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.ProductPurityDto;
import com.goldprice.goldprice.entity.ProductPurityEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.ProductPurityRepository;
import com.goldprice.goldprice.service.ProductPurityService;

@Service
public class ProductPurityServiceImpl implements ProductPurityService {

	@Autowired
	private ProductPurityRepository productPurityRepository;
	@Autowired
	private GenerateMapper productPurityMapper;

	/**
	 * Get ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to get
	 * 
	 * @return productPurityDto Object contains information about an productPurity in database
	 */
	@Override
	public Object getProductPurity(ProductPurityDto productPurityDto) {
		return productPurityMapper.productPurityEntityToProductPurityDto(productPurityRepository.findOneById(productPurityDto.getId()));
	}

	/**
	 * Get All ProductPurity
	 * 
	 * @return productPurityDto Object contains all information about productPurity in database
	 */
	@Override
	public Object getAllProductPurity() {
		return productPurityMapper.listProductPurityEntityToListProductPurityDto(productPurityRepository.findAll());
	}

	/**
	 * Add ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addProductPurity(ProductPurityDto productPurityDto) {
		ProductPurityEntity productPurityEntity = productPurityMapper.productPurityDtoToProductPurityEntity(productPurityDto);
		productPurityRepository.save(productPurityEntity);
		return true;
	}

	/**
	 * Update ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateProductPurity(ProductPurityDto productPurityDto) {
		ProductPurityEntity productPurityEntityUpdate = productPurityRepository.findOneById(productPurityDto.getId());
		if (productPurityEntityUpdate != null) {
			// Case: ProductPurity is in database
			productPurityEntityUpdate.setName(productPurityDto.getName());
			productPurityRepository.save(productPurityEntityUpdate);
			return true;
		} else {
			throw new ProductException("ProductPurity Not Found!");
		}
	}

	/**
	 * Delete ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteProductPurity(ProductPurityDto productPurityDto) {
		productPurityRepository.deleteById(productPurityDto.getId());
		return true;
	}

}
