package com.goldprice.goldprice.entity.product;

import java.math.BigDecimal;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductEntity extends BaseEntity {
	private String name;
	private String description;
	private int weight;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "purity_id", referencedColumnName = "id")
	private ProductPurityEntity productPurityEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id", referencedColumnName = "id")
	private ProductTypeEntity productTypeEntity;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "material_id", referencedColumnName = "id")
	private ProductMaterialEntity productMaterialEntity;

	private BigDecimal price;
	private int inStock;
	private String imageUrl;

	public ProductEntity() {
		super();
	}

	public ProductEntity(String name, String description, int weight, ProductPurityEntity productPurityEntity,
			ProductTypeEntity productTypeEntity, ProductMaterialEntity productMaterialEntity, BigDecimal price,
			int inStock, String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.productPurityEntity = productPurityEntity;
		this.productTypeEntity = productTypeEntity;
		this.productMaterialEntity = productMaterialEntity;
		this.price = price;
		this.inStock = inStock;
		this.imageUrl = imageUrl;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public ProductPurityEntity getProductPurityEntity() {
		return productPurityEntity;
	}

	public void setProductPurityEntity(ProductPurityEntity productPurityEntity) {
		this.productPurityEntity = productPurityEntity;
	}

	public ProductTypeEntity getProductTypeEntity() {
		return productTypeEntity;
	}

	public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
		this.productTypeEntity = productTypeEntity;
	}

	public ProductMaterialEntity getProductMaterialEntity() {
		return productMaterialEntity;
	}

	public void setProductMaterialEntity(ProductMaterialEntity productMaterialEntity) {
		this.productMaterialEntity = productMaterialEntity;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public int getInStock() {
		return inStock;
	}

	public void setInStock(int inStock) {
		this.inStock = inStock;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

}
