package com.sakk.princess.patient.service.exception;

public class DuplicateMotorVehicleAccidentException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public DuplicateMotorVehicleAccidentException() {
	}

	public DuplicateMotorVehicleAccidentException(String message) {
		super(message);
	}

	public DuplicateMotorVehicleAccidentException(Throwable cause) {
		super(cause);
	}

	public DuplicateMotorVehicleAccidentException(String message, Throwable cause) {
		super(message, cause);
	}

	public DuplicateMotorVehicleAccidentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
