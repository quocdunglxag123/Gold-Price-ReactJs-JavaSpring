package com.goldprice.goldprice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.PaymentOrderEntity;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrderEntity, Long> {
	PaymentOrderEntity findOneById(Long id);

	PaymentOrderEntity findByName(String name);
}