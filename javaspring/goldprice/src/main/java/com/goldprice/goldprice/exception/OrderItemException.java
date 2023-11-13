package com.goldprice.goldprice.exception;

public class OrderItemException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public OrderItemException(String errorMessage) {
		super(errorMessage);
	}
	
}