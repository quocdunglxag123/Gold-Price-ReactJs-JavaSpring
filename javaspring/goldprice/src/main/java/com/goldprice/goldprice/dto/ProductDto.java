package com.goldprice.goldprice.dto;

import java.math.BigDecimal;

public class ProductDto extends BaseDto {
	private String name;
	private String description;
	private int weight;
	private ProductPurityDto productPurityDto;
	private ProductTypeDto productTypeDto;
	private ProductMaterialDto productMaterialDto;
	private BigDecimal price;
	private int inStock;
	private String imageUrl;

	public ProductDto() {
		super();
	}

	public ProductDto(String name, String description, int weight, ProductPurityDto productPurityDto,
			ProductTypeDto productTypeDto, ProductMaterialDto productMaterialDto, BigDecimal price, int inStock,
			String imageUrl) {
		super();
		this.name = name;
		this.description = description;
		this.weight = weight;
		this.productPurityDto = productPurityDto;
		this.productTypeDto = productTypeDto;
		this.productMaterialDto = productMaterialDto;
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

	public ProductPurityDto getProductPurityDto() {
		return productPurityDto;
	}

	public void setProductPurityDto(ProductPurityDto productPurityDto) {
		this.productPurityDto = productPurityDto;
	}

	public ProductTypeDto getProductTypeDto() {
		return productTypeDto;
	}

	public void setProductTypeDto(ProductTypeDto productTypeDto) {
		this.productTypeDto = productTypeDto;
	}

	public ProductMaterialDto getProductMaterialDto() {
		return productMaterialDto;
	}

	public void setProductMaterialDto(ProductMaterialDto productMaterialDto) {
		this.productMaterialDto = productMaterialDto;
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
