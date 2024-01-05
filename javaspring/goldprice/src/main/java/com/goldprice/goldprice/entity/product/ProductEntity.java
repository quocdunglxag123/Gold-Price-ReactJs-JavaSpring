package com.goldprice.goldprice.entity.product;

import java.math.BigDecimal;
import java.util.List;

import com.goldprice.goldprice.entity.BaseEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductEntity extends BaseEntity {
	private String name;
	private String description;
	private int weight;

	@ManyToOne
	@JoinColumn(name = "purity_id")
	private ProductPurityEntity productPurityEntity;

	@ManyToOne
	@JoinColumn(name = "type_id")
	private ProductTypeEntity productTypeEntity;

	@ManyToOne
	@JoinColumn(name = "material_id")
	private ProductMaterialEntity productMaterialEntity;

	@OneToMany(mappedBy = "productEntity", cascade = CascadeType.ALL)
	private List<ProductImgEntity> productImgEntities;

	private BigDecimal price;
	private int inStock;

	public ProductEntity() {
		super();
	}

	public ProductEntity(String name, String description, int weight, ProductPurityEntity productPurityEntity,
			ProductTypeEntity productTypeEntity, ProductMaterialEntity productMaterialEntity,
			List<ProductImgEntity> productImgEntities, BigDecimal price, int inStock) {
		super();
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.productPurityEntity = productPurityEntity;
		this.productTypeEntity = productTypeEntity;
		this.productMaterialEntity = productMaterialEntity;
		this.productImgEntities = productImgEntities;
		this.price = price;
		this.inStock = inStock;
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

	public List<ProductImgEntity> getProductImgEntities() {
		return productImgEntities;
	}

	public void setProductImgEntities(List<ProductImgEntity> productImgEntities) {
		this.productImgEntities = productImgEntities;
	}

}
