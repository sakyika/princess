package com.sakk.princess.core.service.exceptions;

public class RoleNotFoundException extends RuntimeException {
	private static final long serialVersionUID = -1402337502045439388L;

	public RoleNotFoundException() {
	}

	public RoleNotFoundException(String message) {
		super(message);
	}

	public RoleNotFoundException(Throwable cause) {
		super(cause);
	}

	public RoleNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public RoleNotFoundException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
