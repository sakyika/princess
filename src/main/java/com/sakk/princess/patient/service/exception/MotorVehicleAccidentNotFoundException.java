package com.sakk.princess.patient.service.exception;

public class MotorVehicleAccidentNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 2663040220470909688L;

	public MotorVehicleAccidentNotFoundException() {
	}

	public MotorVehicleAccidentNotFoundException(String message) {
		super(message);
	}

	public MotorVehicleAccidentNotFoundException(Throwable cause) {
		super(cause);
	}

	public MotorVehicleAccidentNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public MotorVehicleAccidentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
