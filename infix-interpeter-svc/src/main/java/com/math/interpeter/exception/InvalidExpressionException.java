package com.math.interpeter.exception;

import lombok.Getter;

@Getter
public class InvalidExpressionException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String code;
	private String message;
	
	public InvalidExpressionException(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
}
