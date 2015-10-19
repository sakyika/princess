package com.sakk.princess.patient.service.exception;

public class DuplicateHomeAccidentException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateHomeAccidentException() {
	}

	public DuplicateHomeAccidentException(String message) {
		super(message);
	}

	public DuplicateHomeAccidentException(Throwable cause) {
		super(cause);
	}

	public DuplicateHomeAccidentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateHomeAccidentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
