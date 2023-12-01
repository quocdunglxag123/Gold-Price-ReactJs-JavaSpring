package com.goldprice.goldprice.service.product;

import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductDto;

@Service
public interface ProductService {
	/**
	 * Get Product
	 * 
	 * @param productDto ProductDto contains information about a product to get
	 * 
	 * @return productDto Object contains information about a product in database
	 */
	Object getProduct(ProductDto productDto);

	/**
	 * Get All Products
	 * 
	 * @return productDto Object contains all information about products in database
	 */
	Object getAllProducts();

	/**
	 * Add Product
	 * 
	 * @param productDto ProductDto contains information about a product to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	Object addProduct(ProductDto productDto);

	/**
	 * Delete Product
	 * 
	 * @param productDto ProductDto contains information about a product to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	Object deleteProduct(ProductDto productDto);

	/**
	 * Update Product
	 * 
	 * @param productDto ProductDto contains information about a product to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	Object updateProduct(ProductDto productDto);
}
