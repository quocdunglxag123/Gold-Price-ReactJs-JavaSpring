package com.goldprice.goldprice.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductMaterialDto;
import com.goldprice.goldprice.entity.product.ProductMaterialEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.product.ProductMaterialRepository;
import com.goldprice.goldprice.service.product.ProductMaterialService;

@Service
public class ProductMaterialServiceImpl implements ProductMaterialService {

	@Autowired
	private ProductMaterialRepository productMaterialRepository;
	@Autowired
	private GenerateMapper productMaterialMapper;

	/**
	 * Get ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to get
	 * 
	 * @return productMaterialDto Object contains information about an productMaterial in database
	 */
	@Override
	public Object getProductMaterial(ProductMaterialDto productMaterialDto) {
		return productMaterialMapper.productMaterialEntityToProductMaterialDto(productMaterialRepository.findOneById(productMaterialDto.getId()));
	}

	/**
	 * Get All ProductMaterial
	 * 
	 * @return productMaterialDto Object contains all information about productMaterial in database
	 */
	@Override
	public Object getAllProductMaterial() {
		return productMaterialMapper.listProductMaterialEntityToListProductMaterialDto(productMaterialRepository.findAll());
	}

	/**
	 * Add ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addProductMaterial(ProductMaterialDto productMaterialDto) {
		ProductMaterialEntity productMaterialEntity = productMaterialMapper.productMaterialDtoToProductMaterialEntity(productMaterialDto);
		productMaterialRepository.save(productMaterialEntity);
		return true;
	}

	/**
	 * Update ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateProductMaterial(ProductMaterialDto productMaterialDto) {
		ProductMaterialEntity productMaterialEntityUpdate = productMaterialRepository.findOneById(productMaterialDto.getId());
		if (productMaterialEntityUpdate != null) {
			// Case: ProductMaterial is in database
			productMaterialEntityUpdate.setName(productMaterialDto.getName());
			productMaterialRepository.save(productMaterialEntityUpdate);
			return true;
		} else {
			throw new ProductException("ProductMaterial Not Found!");
		}
	}

	/**
	 * Delete ProductMaterial
	 * 
	 * @param productMaterialDto ProductMaterialDto contains information about an productMaterial to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteProductMaterial(ProductMaterialDto productMaterialDto) {
		productMaterialRepository.deleteById(productMaterialDto.getId());
		return true;
	}

}
