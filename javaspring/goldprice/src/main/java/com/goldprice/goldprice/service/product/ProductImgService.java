package com.goldprice.goldprice.service.product;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductImgDto;

@Service
public interface ProductImgService {
	/**
	 * Get ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to get
	 * 
	 * @return productImgDto Object contains information about an productImg in database
	 */
	Object getProductImg(ProductImgDto productImgDto);

	/**
	 * Get All ProductImg
	 * 
	 * @return productImgDto Object contains all information about productImg in database
	 */
	Object getAllProductImg();

	/**
	 * Add ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addProductImg(ProductImgDto productImgDto);

	/**
	 * Delete ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteProductImg(ProductImgDto productImgDto);

	/**
	 * Update ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateProductImg(ProductImgDto productImgDto);
}
