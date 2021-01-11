package com.shristi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shristi.service.OrderConsumer;

@RestController
public class BillController {

	@Autowired
	OrderConsumer orderConsumer;
	@GetMapping("/receive-order")
	public String receiveOrders(){
	return orderConsumer.receive();
		
	}
}
