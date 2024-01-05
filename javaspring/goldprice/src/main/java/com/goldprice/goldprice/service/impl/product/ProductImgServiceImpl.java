package com.goldprice.goldprice.service.impl.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.goldprice.goldprice.dto.product.ProductImgDto;
import com.goldprice.goldprice.entity.product.ProductEntity;
import com.goldprice.goldprice.entity.product.ProductImgEntity;
import com.goldprice.goldprice.exception.ProductException;
import com.goldprice.goldprice.mapstruct.GenerateMapper;
import com.goldprice.goldprice.repository.product.ProductImgRepository;
import com.goldprice.goldprice.repository.product.ProductRepository;
import com.goldprice.goldprice.service.product.ProductImgService;

@Service
public class ProductImgServiceImpl implements ProductImgService {

	@Autowired
	private ProductImgRepository productImgRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private GenerateMapper productImgMapper;

	/**
	 * Get ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to get
	 * 
	 * @return productImgDto Object contains information about an productImg in database
	 */
	@Override
	public Object getProductImg(ProductImgDto productImgDto) {
		return productImgMapper.productImgEntityToProductImgDto(productImgRepository.findOneById(productImgDto.getId()));
	}

	/**
	 * Get All ProductImg
	 * 
	 * @return productImgDto Object contains all information about productImg in database
	 */
	@Override
	public Object getAllProductImg() {
		return productImgMapper.listProductImgEntityToListProductImgDto(productImgRepository.findAll());
	}

	/**
	 * Add ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to add
	 * 
	 * @return true/Exception Success/failed to add
	 */
	@Override
	public Object addProductImg(ProductImgDto productImgDto) {
		ProductImgEntity productImgEntity = productImgMapper.productImgDtoToProductImgEntity(productImgDto);
		productImgRepository.save(productImgEntity);
		return true;
	}

	/**
	 * Update ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to update
	 * 
	 * @return true/Exception Success/failed to update
	 */
	@Override
	public Object updateProductImg(ProductImgDto productImgDto) {
		ProductImgEntity productImgEntityUpdate = productImgRepository.findOneById(productImgDto.getId());
		if (productImgEntityUpdate != null) {
			// Case: ProductImg is in database
			if(productImgDto.getName() != null ) {
				productImgEntityUpdate.setName(productImgDto.getName());
			}
			if(productImgDto.getProductId() != null ) {
				ProductEntity productEntity = productRepository.findOneById(productImgDto.getProductId());
				productImgEntityUpdate.setProductEntity(productEntity);

			}
			productImgRepository.save(productImgEntityUpdate);
			return true;
		} else {
			throw new ProductException("Product Image Not Found!");
		}
	}

	/**
	 * Delete ProductImg
	 * 
	 * @param productImgDto ProductImgDto contains information about an productImg to delete
	 * 
	 * @return true/Exception Success/failed to delete
	 */
	@Override
	public Object deleteProductImg(ProductImgDto productImgDto) {
		productImgRepository.deleteById(productImgDto.getId());
		return true;
	}

}
