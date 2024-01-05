package com.goldprice.goldprice.dto.product;

import com.goldprice.goldprice.dto.BaseDto;

public class ProductImgDto extends BaseDto {
	private String name;
	private String url;
	private Long productId;

	public ProductImgDto() {
		super();
	}

	public ProductImgDto(String name, String url, Long productId) {
		super();
		this.name = name;
		this.url = url;
		this.productId = productId;
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

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

}
