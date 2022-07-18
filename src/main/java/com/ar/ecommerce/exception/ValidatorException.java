package com.ar.ecommerce.exception;

public class ValidatorException extends Exception {

	private static final long serialVersionUID = 1L;

	public ValidatorException() {
		super();
	}

	public ValidatorException(String message) {
	   super(message);
	}
	
    public ValidatorException(String message, Throwable cause) {
        super(message, cause);
    }
}
