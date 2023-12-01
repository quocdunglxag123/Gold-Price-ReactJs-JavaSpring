package com.goldprice.goldprice.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.product.ProductTypeEntity;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypeEntity, Long> {
	ProductTypeEntity findOneById(Long id);

	ProductTypeEntity findByName(String name);
}