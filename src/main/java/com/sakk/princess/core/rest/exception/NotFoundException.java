package com.sakk.princess.core.rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 40724215450871427L;

	public NotFoundException() {
	}

	public NotFoundException(Throwable cause) {
		super(cause);
	}
}
