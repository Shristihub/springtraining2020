package com.bookapp.exception;

public class BookNotFoundException extends Exception {

	public BookNotFoundException() {
		// TODO Auto-generated constructor stub
	}

	public BookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	public BookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
