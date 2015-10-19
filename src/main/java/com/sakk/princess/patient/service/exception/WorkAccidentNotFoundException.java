package com.sakk.princess.patient.service.exception;

public class WorkAccidentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public WorkAccidentNotFoundException() {
	}

	public WorkAccidentNotFoundException(String message) {
		super(message);
	}

	public WorkAccidentNotFoundException(Throwable cause) {
		super(cause);
	}

	public WorkAccidentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public WorkAccidentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
