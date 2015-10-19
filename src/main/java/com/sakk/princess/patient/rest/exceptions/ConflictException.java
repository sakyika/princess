package com.sakk.princess.patient.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = 3848161682098909354L;

	public ConflictException() {

	}

	public ConflictException(Throwable cause) {
		super(cause);
	}

}
