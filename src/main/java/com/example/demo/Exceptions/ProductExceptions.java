package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ProductNotFound due to invalid data.")
public class ProductExceptions extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductExceptions(String message, Throwable cause) {
		super(message, cause);
	}

	public ProductExceptions(String message) {
		super(message);
	}

	public ProductExceptions(Throwable cause) {
		super(cause);
	}
	
	

}
