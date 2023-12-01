package com.goldprice.goldprice.service.product;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductPurityDto;

@Service
public interface ProductPurityService {
	/**
	 * Get ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to get
	 * 
	 * @return productPurityDto Object contains information about an productPurity in database
	 */
	Object getProductPurity(ProductPurityDto productPurityDto);

	/**
	 * Get All ProductPurity
	 * 
	 * @return productPurityDto Object contains all information about productPurity in database
	 */
	Object getAllProductPurity();

	/**
	 * Add ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addProductPurity(ProductPurityDto productPurityDto);

	/**
	 * Delete ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteProductPurity(ProductPurityDto productPurityDto);

	/**
	 * Update ProductPurity
	 * 
	 * @param productPurityDto ProductPurityDto contains information about an productPurity to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateProductPurity(ProductPurityDto productPurityDto);
}
