package com.goldprice.goldprice.exception;

public class TokenException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public TokenException(String errorMessage) {
		super(errorMessage);
	}

}