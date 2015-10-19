package com.sakk.princess.patient.service.exception;

public class ChildhoodTruamaNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public ChildhoodTruamaNotFoundException() {
	}

	public ChildhoodTruamaNotFoundException(String message) {
		super(message);
	}

	public ChildhoodTruamaNotFoundException(Throwable cause) {
		super(cause);
	}

	public ChildhoodTruamaNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChildhoodTruamaNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
