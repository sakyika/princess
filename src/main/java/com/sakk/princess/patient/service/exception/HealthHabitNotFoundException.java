package com.sakk.princess.patient.service.exception;

public class HealthHabitNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public HealthHabitNotFoundException() {
	}

	public HealthHabitNotFoundException(String message) {
		super(message);
	}

	public HealthHabitNotFoundException(Throwable cause) {
		super(cause);
	}

	public HealthHabitNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public HealthHabitNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
