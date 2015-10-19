package com.sakk.princess.patient.service.exception;

public class DuplicateSportsAccidentException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateSportsAccidentException() {
	}

	public DuplicateSportsAccidentException(String message) {
		super(message);
	}

	public DuplicateSportsAccidentException(Throwable cause) {
		super(cause);
	}

	public DuplicateSportsAccidentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateSportsAccidentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
