package com.goldprice.goldprice.entity.product;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductType")
public class ProductTypeEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	public ProductTypeEntity() {
		super();
	}

	public ProductTypeEntity(String name) {
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
