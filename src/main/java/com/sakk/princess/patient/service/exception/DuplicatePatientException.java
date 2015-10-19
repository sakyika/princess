package com.sakk.princess.patient.service.exception;

public class DuplicatePatientException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicatePatientException() {
	}

	public DuplicatePatientException(String message) {
		super(message);
	}

	public DuplicatePatientException(Throwable cause) {
		super(cause);
	}

	public DuplicatePatientException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicatePatientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
