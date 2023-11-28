package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.ProductMaterialEntity;

@Repository
public interface ProductMaterialRepository extends JpaRepository<ProductMaterialEntity, Long> {
	ProductMaterialEntity findOneById(Long id);

	ProductMaterialEntity findByName(String name);
}