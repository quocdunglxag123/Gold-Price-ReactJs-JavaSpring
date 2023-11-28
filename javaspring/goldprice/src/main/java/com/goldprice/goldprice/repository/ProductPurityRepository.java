package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.ProductPurityEntity;

@Repository
public interface ProductPurityRepository extends JpaRepository<ProductPurityEntity, Long> {
	ProductPurityEntity findOneById(Long id);

	ProductPurityEntity findByName(String name);
}