package com.goldprice.goldprice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.ProductDto;
import com.goldprice.goldprice.entity.ProductEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.ProductRepository;
import com.goldprice.goldprice.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private GenerateMapper productMapper;

	/**
	 * Get Product
	 * 
	 * @param productDto ProductDto contains information about a product to get
	 * 
	 * @return productDto Object contains information about a product in the
	 *         database
	 */
	@Override
	public Object getProduct(ProductDto productDto) {
		return productMapper.productEntityToProductDto(productRepository.findOneById(productDto.getId()));
	}

	/**
	 * Get All Products
	 * 
	 * @return productDto Object contains all information about products in the
	 *         database
	 */
	@Override
	public Object getAllProducts() {
		return productMapper.listProductEntityToListProductDto(productRepository.findAll());
	}

	/**
	 * Add Product
	 * 
	 * @param productDto ProductDto contains information about a product to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addProduct(ProductDto productDto) {
		ProductEntity productEntity = productMapper.productDtoToProductEntity(productDto);
		productRepository.save(productEntity);
		return true;
	}

	/**
	 * Update Product
	 * 
	 * @param productDto ProductDto contains information about a product to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateProduct(ProductDto productDto) {
		ProductEntity productEntityUpdate = productRepository.findOneById(productDto.getId());
		if (productEntityUpdate != null) {
			// Case: Product is in the database
			if(productDto.getProductName() != null) {
				productEntityUpdate.setProductName(productDto.getProductName());
			}
			
			if(productDto.getImageUrl() != null) {
				productEntityUpdate.setImageUrl(productDto.getImageUrl());
			}
			if(productDto.getInStock() >=0 ) {
				productEntityUpdate.setInStock(productDto.getInStock());
			}
			if(productDto.getPrice() != null) {
				productEntityUpdate.setPrice(productDto.getPrice());
			}
			if(productDto.getPurity() != null) {
				productEntityUpdate.setPurity(productDto.getPurity());
			}
			if(productDto.getDescription() != null) {
				productEntityUpdate.setDescription(productDto.getDescription());
			}
			
			if(productDto.getWeight()>= 0) {
				productEntityUpdate.setWeight(productDto.getWeight());
			}
			
			productRepository.save(productEntityUpdate);
			return true;
		} else {
			throw new ProductException("Product Not Found!"); // Đổi từ RoleException sang ProductException
		}
	}

	/**
	 * Delete Product
	 * 
	 * @param productDto ProductDto contains information about a product to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteProduct(ProductDto productDto) {
		productRepository.deleteById(productDto.getId());
		return true;
	}
}
