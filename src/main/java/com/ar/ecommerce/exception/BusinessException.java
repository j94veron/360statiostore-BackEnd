package com.ar.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	
	public BusinessException() {
		super();
		httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public BusinessException(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}
	
	public BusinessException(HttpStatus httpStatus, String message) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
