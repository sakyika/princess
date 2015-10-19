package com.sakk.princess.core.service.exceptions;

public class RoleExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3657755294478079531L;

	public RoleExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleExistsException(String message) {
		super(message);
	}

	public RoleExistsException() {
		super();
	}
}
