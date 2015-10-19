package com.sakk.princess.patient.service.exception;

public class DuplicateChiropracticExperienceException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateChiropracticExperienceException() {
	}

	public DuplicateChiropracticExperienceException(String message) {
		super(message);
	}

	public DuplicateChiropracticExperienceException(Throwable cause) {
		super(cause);
	}

	public DuplicateChiropracticExperienceException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateChiropracticExperienceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
