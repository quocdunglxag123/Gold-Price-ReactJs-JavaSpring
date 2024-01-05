package com.goldprice.goldprice.entity.product;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductImg")
public class ProductImgEntity extends BaseEntity {
	@ManyToOne
	@JoinColumn(name = "productId")
	private ProductEntity productEntity;

	@Column(unique = true, nullable = false)
	private String name;

	@Column(unique = true, nullable = false)
	private String url;

	public ProductImgEntity() {
		super();
	}

	public ProductImgEntity(ProductEntity productEntity, String name, String url) {
		super();
		this.productEntity = productEntity;
		this.name = name;
		this.url = url;
	}

	public ProductEntity getProductEntity() {
		return productEntity;
	}

	public void setProductEntity(ProductEntity productEntity) {
		this.productEntity = productEntity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
