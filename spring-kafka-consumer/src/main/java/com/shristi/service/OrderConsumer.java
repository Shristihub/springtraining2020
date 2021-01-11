package com.shristi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {
	private final Logger logger = LoggerFactory.getLogger(OrderConsumer.class);
	
	String message;
	@KafkaListener(groupId = "group_id",topics = "shristi-topic")
	public void receiveOrderDetails(String message){
		System.out.println("Consumed message "+ message);
		this.message =  message;
	}
	public String receive(){
		return message;
	}
}
