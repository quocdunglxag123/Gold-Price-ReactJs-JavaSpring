package com.goldprice.goldprice.entity.order;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "PaymentOrder")
public class PaymentOrderEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	public PaymentOrderEntity() {
		super();
	}

	public PaymentOrderEntity(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
