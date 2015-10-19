package com.sakk.princess.core.service.exceptions;

public class PermissionExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2165023589800038977L;

	public PermissionExistsException(String message, Throwable cause) {
		super(message, cause);
	}

	public PermissionExistsException(String message) {
		super(message);
	}

	public PermissionExistsException() {
		super();
	}
}
