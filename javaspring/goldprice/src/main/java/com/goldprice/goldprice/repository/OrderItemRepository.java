package com.goldprice.goldprice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.OrderItemEntity;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, Long> {
	OrderItemEntity findOneById(Long id);
	
	@Query(value = "SELECT * FROM order_items WHERE order_items.product_id = :productId", nativeQuery = true)
	List<OrderItemEntity> findByProductId(@Param("productId") Long productId);
}