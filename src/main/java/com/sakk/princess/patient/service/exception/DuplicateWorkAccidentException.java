package com.sakk.princess.patient.service.exception;

public class DuplicateWorkAccidentException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateWorkAccidentException() {
	}

	public DuplicateWorkAccidentException(String message) {
		super(message);
	}

	public DuplicateWorkAccidentException(Throwable cause) {
		super(cause);
	}

	public DuplicateWorkAccidentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateWorkAccidentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
