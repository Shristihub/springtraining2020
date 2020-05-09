package com.example.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class APIErrors {
	String message;
	LocalDateTime timeStamp;
	HttpStatus status;
	List<String> details;

}
