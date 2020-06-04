package com.greetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/hello")
	public String sayHello() {
		return "Welcome to Spring";
	}
}
