package com.sakk.princess.patient.service.exception;

public class HomeAccidentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public HomeAccidentNotFoundException() {
	}

	public HomeAccidentNotFoundException(String message) {
		super(message);
	}

	public HomeAccidentNotFoundException(Throwable cause) {
		super(cause);
	}

	public HomeAccidentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public HomeAccidentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
