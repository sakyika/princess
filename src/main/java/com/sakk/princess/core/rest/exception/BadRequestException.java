package com.sakk.princess.core.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1085901373081563949L;

	public BadRequestException() {
	}

	public BadRequestException(Throwable cause) {
		super(cause);
	}
}
