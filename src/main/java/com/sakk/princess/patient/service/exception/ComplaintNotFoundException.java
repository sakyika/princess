package com.sakk.princess.patient.service.exception;

public class ComplaintNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2663040220470909688L;

	public ComplaintNotFoundException() {
	}

	public ComplaintNotFoundException(String message) {
		super(message);
	}

	public ComplaintNotFoundException(Throwable cause) {
		super(cause);
	}

	public ComplaintNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ComplaintNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
