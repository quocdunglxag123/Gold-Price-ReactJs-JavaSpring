package com.goldprice.goldprice.exception;

public class StatusOrderException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public StatusOrderException(String errorMessage) {
		super(errorMessage);
	}
	
}