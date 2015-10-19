package com.sakk.princess.patient.service.exception;

public class ChiropracticExperienceNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public ChiropracticExperienceNotFoundException() {
	}

	public ChiropracticExperienceNotFoundException(String message) {
		super(message);
	}

	public ChiropracticExperienceNotFoundException(Throwable cause) {
		super(cause);
	}

	public ChiropracticExperienceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public ChiropracticExperienceNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
