package com.example.trial;

import org.springframework.stereotype.Component;

@Component
public class Greetings {

	public String sayHello(String name) {
		return "welcome "+name;
	}
}
