package com.goldprice.goldprice.exception;

public class PaymentOrderException  extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public PaymentOrderException(String errorMessage) {
		super(errorMessage);
	}
	
}