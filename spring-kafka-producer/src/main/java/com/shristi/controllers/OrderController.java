package com.shristi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shristi.service.OrderProducer;

@RestController
public class OrderController {

	@Autowired
	OrderProducer orderProducer;
	@GetMapping("/send-order/{message}")
	public ResponseEntity<String> greetMessage(@PathVariable("message")String message){
		//service class
		orderProducer.sendOrderDetails(message);
		return ResponseEntity.ok().body("Send Message");
		
	}
}
