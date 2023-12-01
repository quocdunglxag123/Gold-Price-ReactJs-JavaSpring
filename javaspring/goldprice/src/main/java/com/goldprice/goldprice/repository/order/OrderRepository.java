package com.goldprice.goldprice.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.order.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
	OrderEntity findOneById(Long id);
}