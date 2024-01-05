package com.goldprice.goldprice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.product.ProductImgEntity;

@Repository
public interface ProductImgRepository extends JpaRepository<ProductImgEntity, Long> {
	ProductImgEntity findOneById(Long id);

	ProductImgEntity findByName(String name);
	ProductImgEntity findOneByName(String name);
}