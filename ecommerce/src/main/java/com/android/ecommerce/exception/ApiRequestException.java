package com.android.ecommerce.exception;

public class ApiRequestException extends RuntimeException {

	private static final long serialVersionUID = -7321696099849578427L;
	
	public ApiRequestException(String message) {
		super(message);
	}
	
	public ApiRequestException(String message, Throwable cause) {
		super(message, cause);
	}
}
