package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.StatusOrderEntity;

@Repository
public interface StatusOrderRepository extends JpaRepository<StatusOrderEntity, Long> {
	StatusOrderEntity findOneById(Long id);

	StatusOrderEntity findByStatusOrderName(String statusName);
}