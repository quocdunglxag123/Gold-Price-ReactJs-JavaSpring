package com.goldprice.goldprice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.product.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
	ProductEntity findOneById(Long id);
	ProductEntity findOneByName(String name);
}