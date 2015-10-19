package com.sakk.princess.patient.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1433407882715357963L;

	public BadRequestException() {

	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}

}
