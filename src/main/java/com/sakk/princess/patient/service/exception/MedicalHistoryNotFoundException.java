package com.sakk.princess.patient.service.exception;

public class MedicalHistoryNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public MedicalHistoryNotFoundException() {
	}

	public MedicalHistoryNotFoundException(String message) {
		super(message);
	}

	public MedicalHistoryNotFoundException(Throwable cause) {
		super(cause);
	}

	public MedicalHistoryNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MedicalHistoryNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
