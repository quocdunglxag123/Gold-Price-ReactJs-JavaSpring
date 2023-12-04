package com.goldprice.goldprice.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.goldprice.goldprice.dto.product.ProductDto;
import com.goldprice.goldprice.entity.product.ProductEntity;
import com.goldprice.goldprice.entity.product.ProductMaterialEntity;
import com.goldprice.goldprice.entity.product.ProductPurityEntity;
import com.goldprice.goldprice.entity.product.ProductTypeEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.ProductMapper;
import com.goldprice.goldprice.repository.product.ProductMaterialRepository;
import com.goldprice.goldprice.repository.product.ProductPurityRepository;
import com.goldprice.goldprice.repository.product.ProductRepository;
import com.goldprice.goldprice.repository.product.ProductTypeRepository;
import com.goldprice.goldprice.service.product.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductTypeRepository productTypeRepository;
	@Autowired
	private ProductMaterialRepository productMaterialRepository;
	@Autowired
	private ProductPurityRepository productPurityRepository;
	@Autowired
	private ProductMapper productMapper;

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
		ProductEntity productEntity = productRepository.findOneById(productDto.getId());
		return productMapper.productEntityToProductDto(productEntity);
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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object addProduct(ProductDto productDto) {
		ProductEntity productEntity = productMapper.productDtoToProductEntity(productDto);

		productEntity = getProductInfoByIdAndName(productDto, productEntity, true);

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
	@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public Object updateProduct(ProductDto productDto) {
		ProductEntity productEntityUpdate = productRepository.findOneById(productDto.getId());
		if (productEntityUpdate != null) {
			// Case: Product is in the database
			if (productDto.getName() != null) {
				productEntityUpdate.setName(productDto.getName());
			}

			if (productDto.getImageUrl() != null) {
				productEntityUpdate.setImageUrl(productDto.getImageUrl());
			}
			if (productDto.getInStock() >= 0) {
				productEntityUpdate.setInStock(productDto.getInStock());
			}
			if (productDto.getPrice() != null) {
				productEntityUpdate.setPrice(productDto.getPrice());
			}

			if (productDto.getDescription() != null) {
				productEntityUpdate.setDescription(productDto.getDescription());
			}

			if (productDto.getWeight() >= 0) {
				productEntityUpdate.setWeight(productDto.getWeight());
			}

			productEntityUpdate = getProductInfoByIdAndName(productDto, productEntityUpdate, false);

			productRepository.save(productEntityUpdate);
			return true;
		} else {
			throw new ProductException("Product Not Found!");
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

	/**
	 * Get Info About Product (Type, Material, Purity)
	 * 
	 * @param productDto    ProductDto contains information about a product
	 * @param productEntity ProductEntity contains information about a product
	 * @param flagAdd       boolean Flag check update or add
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	private ProductEntity getProductInfoByIdAndName(ProductDto productDto, ProductEntity productEntity,
			boolean flagAdd) {
		// Get Product Type Entity
		if (productDto.getProductTypeDto() != null) {
			ProductTypeEntity productTypeEntity = new ProductTypeEntity();
			// Find By Name
			if (productDto.getProductTypeDto().getName() != null || productDto.getProductTypeDto().getName() != "") {
				productTypeEntity = productTypeRepository.findByName(productDto.getProductTypeDto().getName());
			}
			// Find By Id
			if (productDto.getProductTypeDto().getId() != null) {
				productTypeEntity = productTypeRepository.findOneById(productDto.getProductTypeDto().getId());
			}

			// Check Existed Data
			if (productTypeEntity == null) {
				throw new ProductException("Product Type Not Found!");
			}
			productEntity.setProductTypeEntity(productTypeEntity);

		} else if (flagAdd) {
			throw new ProductException("Please Add Product Type!");
		}

		// Get Product Purity Entity
		if (productDto.getProductPurityDto() != null) {
			ProductPurityEntity productPurityEntity = new ProductPurityEntity();
			// Find By Name
			if (productDto.getProductPurityDto().getName() != null
					|| productDto.getProductPurityDto().getName() != "") {
				productPurityEntity = productPurityRepository.findByName(productDto.getProductPurityDto().getName());
			}
			// Find By Id
			if (productDto.getProductPurityDto().getId() != null) {
				productPurityEntity = productPurityRepository.findOneById(productDto.getProductPurityDto().getId());
			}
			// Check Existed Data
			if (productPurityEntity == null) {
				throw new ProductException("Product Purity Not Found!");
			}
			productEntity.setProductPurityEntity(productPurityEntity);
		} else if (flagAdd) {
			throw new ProductException("Please Add Product Purity!");
		}

		// Get Product Material Entity
		if (productDto.getProductMaterialDto() != null) {
			ProductMaterialEntity productMaterialEntity = new ProductMaterialEntity();
			// Find By Name
			if (productDto.getProductMaterialDto().getName() != null) {
				productMaterialEntity = productMaterialRepository
						.findByName(productDto.getProductMaterialDto().getName());
			}

			// Find By Id
			if (productDto.getProductMaterialDto().getId() != null) {
				productMaterialEntity = productMaterialRepository
						.findOneById(productDto.getProductMaterialDto().getId());
			}

			// Check Existed Data
			if (productMaterialEntity == null) {
				throw new ProductException("Product Material Not Found!");
			}
			productEntity.setProductMaterialEntity(productMaterialEntity);

		} else if (flagAdd) {
			throw new ProductException("Please Add Product Material!");
		}

		return productEntity;
	}
}
