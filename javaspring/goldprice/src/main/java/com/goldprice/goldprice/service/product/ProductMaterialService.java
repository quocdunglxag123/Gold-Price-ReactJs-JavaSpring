package com.goldprice.goldprice.service.product;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductMaterialDto;

@Service
public interface ProductMaterialService {
	/**
	 * Get ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to get
	 * 
	 * @return productMaterialDto Object contains information about an productMaterial in database
	 */
	Object getProductMaterial(ProductMaterialDto productMaterialDto);

	/**
	 * Get All ProductMaterial
	 * 
	 * @return productMaterialDto Object contains all information about productMaterial in database
	 */
	Object getAllProductMaterial();

	/**
	 * Add ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addProductMaterial(ProductMaterialDto productMaterialDto);

	/**
	 * Delete ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteProductMaterial(ProductMaterialDto productMaterialDto);

	/**
	 * Update ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateProductMaterial(ProductMaterialDto productMaterialDto);
}
