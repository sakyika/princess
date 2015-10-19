package com.sakk.princess.patient.service.exception;

public class DuplicateComplaintException extends RuntimeException {

	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateComplaintException() {
	}

	public DuplicateComplaintException(String message) {
		super(message);
	}

	public DuplicateComplaintException(Throwable cause) {
		super(cause);
	}

	public DuplicateComplaintException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateComplaintException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
}
