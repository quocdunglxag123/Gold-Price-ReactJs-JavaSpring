package com.goldprice.goldprice.service;

import org.springframework.stereotype.Service;
import com.goldprice.goldprice.dto.ProductTypeDto;

@Service
public interface ProductTypeService {
	/**
	 * Get ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to get
	 * 
	 * @return productTypeDto Object contains information about an productType in database
	 */
	Object getProductType(ProductTypeDto productTypeDto);

	/**
	 * Get All ProductType
	 * 
	 * @return productTypeDto Object contains all information about productType in database
	 */
	Object getAllProductType();

	/**
	 * Add ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addProductType(ProductTypeDto productTypeDto);

	/**
	 * Delete ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteProductType(ProductTypeDto productTypeDto);

	/**
	 * Update ProductType
	 * 
	 * @param productTypeDto ProductTypeDto contains information about an productType to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateProductType(ProductTypeDto productTypeDto);
}
