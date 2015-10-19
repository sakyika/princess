package com.sakk.princess.patient.service.exception;

public class DuplicateHealthHabitException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateHealthHabitException() {
	}

	public DuplicateHealthHabitException(String message) {
		super(message);
	}

	public DuplicateHealthHabitException(Throwable cause) {
		super(cause);
	}

	public DuplicateHealthHabitException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateHealthHabitException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
