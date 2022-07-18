package com.ar.ecommerce.exception;

import org.springframework.http.HttpStatus;

public class FacthosException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
    private HttpStatus httpStatus;
	
	public FacthosException() {
		super();
		httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
	}

	public FacthosException(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}
	
	public FacthosException(HttpStatus httpStatus, String message) {
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
