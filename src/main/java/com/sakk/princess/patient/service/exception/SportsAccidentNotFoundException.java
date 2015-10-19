package com.sakk.princess.patient.service.exception;

public class SportsAccidentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public SportsAccidentNotFoundException() {
	}

	public SportsAccidentNotFoundException(String message) {
		super(message);
	}

	public SportsAccidentNotFoundException(Throwable cause) {
		super(cause);
	}

	public SportsAccidentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public SportsAccidentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
