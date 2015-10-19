package com.sakk.princess.core.service.exceptions;

public class UserExistsException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4514574188788415060L;

	public UserExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserExistsException(String message) {
		super(message);
	}

	public UserExistsException() {
		super();
	}
}
