package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.trial.Greetings;


@SpringBootApplication
public class SpringBootDemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(SpringBootDemoApplication.class);
		app.run();
		System.out.println(".....hello");
	}

	@Autowired
	Greetings greetings;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inside run method");
		System.out.println(greetings.sayHello("Raju"));
	}
	

}


