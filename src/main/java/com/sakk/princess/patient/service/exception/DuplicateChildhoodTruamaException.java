package com.sakk.princess.patient.service.exception;

public class DuplicateChildhoodTruamaException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateChildhoodTruamaException() {
	}

	public DuplicateChildhoodTruamaException(String message) {
		super(message);
	}

	public DuplicateChildhoodTruamaException(Throwable cause) {
		super(cause);
	}

	public DuplicateChildhoodTruamaException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateChildhoodTruamaException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
