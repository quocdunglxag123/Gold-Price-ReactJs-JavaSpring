package com.goldprice.goldprice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductMaterial")
public class ProductMaterialEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	@OneToOne(mappedBy = "productMaterialEntity")
	private ProductEntity productEntity;

	public ProductMaterialEntity() {
		super();
	}

	public ProductMaterialEntity(String name, ProductEntity productEntity) {
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
