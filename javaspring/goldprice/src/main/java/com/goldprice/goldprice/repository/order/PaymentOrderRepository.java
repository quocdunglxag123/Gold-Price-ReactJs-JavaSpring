package com.goldprice.goldprice.repository.order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goldprice.goldprice.entity.order.PaymentOrderEntity;

@Repository
public interface PaymentOrderRepository extends JpaRepository<PaymentOrderEntity, Long> {
	PaymentOrderEntity findOneById(Long id);

	PaymentOrderEntity findByName(String name);
}