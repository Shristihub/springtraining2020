package com.shristi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class OrderProducer {
	private final Logger logger = LoggerFactory.getLogger(OrderProducer.class);
	
	@Autowired
	KafkaTemplate<String, String> kafkaTemplate;
	
	public void sendOrderDetails(String data){
		logger.info("sending message='{}' to topic='{}'", data, "shristi-topic");
		kafkaTemplate.send("shristi-topic",data);
		
	}
}


