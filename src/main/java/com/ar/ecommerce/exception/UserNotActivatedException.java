package com.ar.ecommerce.exception;

public class UserNotActivatedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserNotActivatedException(String message) {
		super(message);
	}
}
