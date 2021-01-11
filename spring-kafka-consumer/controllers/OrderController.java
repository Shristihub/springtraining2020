package com.shristi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shristi.service.OrderProducer;

@RestController
public class OrderController {

	@Autowired
	OrderProducer orderService;
	@GetMapping("/order-data/{message}")
	public ResponseEntity<String> greetMessage(String message){
		orderService.sendOrderDetails(message);
		return ResponseEntity.ok().body("Send Message");
		
	}
}
