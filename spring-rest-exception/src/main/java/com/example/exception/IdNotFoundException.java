package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IdNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IdNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}
