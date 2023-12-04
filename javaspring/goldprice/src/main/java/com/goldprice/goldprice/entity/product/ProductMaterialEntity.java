package com.goldprice.goldprice.entity.product;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductMaterial")
public class ProductMaterialEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	public ProductMaterialEntity() {
		super();
	}

	public ProductMaterialEntity(String name) {
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
