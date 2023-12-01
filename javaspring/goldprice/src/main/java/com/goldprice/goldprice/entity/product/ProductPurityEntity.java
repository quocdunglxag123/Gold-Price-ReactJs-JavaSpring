package com.goldprice.goldprice.entity.product;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductPurity")
public class ProductPurityEntity extends BaseEntity {
	@Column(unique = true, nullable = false)
	private String name;

	@OneToOne(mappedBy = "productPurityEntity")
	private ProductEntity productEntity;

	public ProductPurityEntity() {
		super();
	}

	public ProductPurityEntity(String name, ProductEntity productEntity) {
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
