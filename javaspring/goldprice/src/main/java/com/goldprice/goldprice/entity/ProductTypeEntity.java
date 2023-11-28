package com.goldprice.goldprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductType")
public class ProductTypeEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	@OneToOne(mappedBy = "productTypeEntity")
	private ProductEntity productEntity;

	public ProductTypeEntity() {
		super();
	}

	public ProductTypeEntity(String name, ProductEntity productEntity) {
		super();
		this.name = name;
		this.productEntity = productEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

}
