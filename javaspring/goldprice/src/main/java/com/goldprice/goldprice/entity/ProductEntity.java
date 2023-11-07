package com.goldprice.goldprice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "Products")
public class ProductEntity extends BaseEntity {
	private String productName;
	private String description;
	private int weight;
	private String purity;
	private String price;
	private int inStock;
	private String imageUrl;

	public ProductEntity() {
		super();
	}

	public ProductEntity(String productName, String description, int weight, String purity, String price, int inStock,
			String imageUrl) {
		super();
		this.productName = productName;
		this.description = description;
		this.weight = weight;
		this.purity = purity;
		this.price = price;
		this.inStock = inStock;
		this.imageUrl = imageUrl;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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

	public String getPurity() {
		return purity;
	}

	public void setPurity(String purity) {
		this.purity = purity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
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
