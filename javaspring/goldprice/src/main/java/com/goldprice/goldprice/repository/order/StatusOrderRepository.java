package com.goldprice.goldprice.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.order.StatusOrderEntity;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrderEntity, Long> {
	StatusOrderEntity findOneById(Long id);

	StatusOrderEntity findByName(String name);
}