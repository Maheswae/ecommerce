package com.mahes.ecommerce.exception;

public class EcommerceException extends RuntimeException{
	String message;
	public EcommerceException() {
		super();
	}
	
	public EcommerceException(String message) {
		super(message);
		this.message = message;
	}
}
