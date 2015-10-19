package com.sakk.princess.patient.service.exception;

public class DuplicateMedicalHistoryException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateMedicalHistoryException() {
	}

	public DuplicateMedicalHistoryException(String message) {
		super(message);
	}

	public DuplicateMedicalHistoryException(Throwable cause) {
		super(cause);
	}

	public DuplicateMedicalHistoryException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateMedicalHistoryException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
