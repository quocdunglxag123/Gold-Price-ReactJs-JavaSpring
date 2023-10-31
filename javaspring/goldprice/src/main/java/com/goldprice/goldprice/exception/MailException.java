package com.goldprice.goldprice.exception;

public class MailException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MailException(String errorMessage) {
		super(errorMessage);
	}

}