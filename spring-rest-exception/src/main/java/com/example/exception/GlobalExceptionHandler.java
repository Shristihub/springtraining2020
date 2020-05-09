package com.example.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> handleIdNotFoundException(IdNotFoundException e) {
		String message= e.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		APIErrors errors = new APIErrors(message, LocalDateTime.now(), HttpStatus.NOT_FOUND, details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
	@ExceptionHandler(AuthorNotFoundException.class)
	public ResponseEntity<Object> handleAuthorNotFoundException(AuthorNotFoundException e) {
		String message= e.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		details.add(e.getLocalizedMessage());
		APIErrors errors = new APIErrors(message, LocalDateTime.now(), HttpStatus.NOT_FOUND, details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message= ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		details.add(ex.getMethod()+" is not supported");
		APIErrors errors = new APIErrors("Method not supported", LocalDateTime.now(),status , details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String message= ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		details.add(ex.getParameterName()+" is Missing");
		details.add(request.getRemoteUser());
		APIErrors errors = new APIErrors("Missing Parameter", LocalDateTime.now(),status , details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String message= ex.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		details.add(ex.getPropertyName()+" is not matching");
		details.add(request.getRemoteUser());
		APIErrors errors = new APIErrors("Type Mismatch", LocalDateTime.now(),status , details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAll(Exception e) {
		String message= e.getMessage();
		List<String> details = new ArrayList<>();
		details.add(message);
		details.add(e.getLocalizedMessage());
		APIErrors errors = new APIErrors(message, LocalDateTime.now(), HttpStatus.NOT_FOUND, details);
		return new ResponseEntity<>(errors,errors.getStatus());
	}
}


