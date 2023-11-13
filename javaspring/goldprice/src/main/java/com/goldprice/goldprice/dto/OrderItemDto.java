package com.goldprice.goldprice.dto;

import java.math.BigDecimal;

public class OrderItemDto extends BaseDto {
	private OrderDto orderDto;

	private ProductDto productDto;

	private int quantity;

	private BigDecimal subtotal;

	public OrderItemDto() {
		super();
	}

	public OrderItemDto(OrderDto orderDto, ProductDto productDto, int quantity, BigDecimal subtotal) {
		super();
		this.orderDto = orderDto;
		this.productDto = productDto;
		this.quantity = quantity;
		this.subtotal = subtotal;
	}

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public ProductDto getProductDto() {
		return productDto;
	}

	public void setProductDto(ProductDto productDto) {
		this.productDto = productDto;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

}