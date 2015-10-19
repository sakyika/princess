package com.sakk.princess.patient.service.exception;

public class DuplicateFamilyHistoryException extends RuntimeException {

	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateFamilyHistoryException() {
	}

	public DuplicateFamilyHistoryException(String message) {
		super(message);
	}

	public DuplicateFamilyHistoryException(Throwable cause) {
		super(cause);
	}

	public DuplicateFamilyHistoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateFamilyHistoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
