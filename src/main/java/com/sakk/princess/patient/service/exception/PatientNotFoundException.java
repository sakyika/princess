package com.sakk.princess.patient.service.exception;

public class PatientNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2663040220470909688L;

	public PatientNotFoundException() {
	}

	public PatientNotFoundException(String message) {
		super(message);
	}

	public PatientNotFoundException(Throwable cause) {
		super(cause);
	}

	public PatientNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public PatientNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
