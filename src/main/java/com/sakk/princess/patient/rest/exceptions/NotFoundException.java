package com.sakk.princess.patient.rest.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 6884580642197986167L;
	

}
