package com.sushma.kafka_producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sushma.kafka_producer.dto.Customer;
import com.sushma.kafka_producer.service.KafkaMessagePublisher;

@Controller
@RequestMapping("/producer-app")
public class EventController {
	
	@Autowired
	KafkaMessagePublisher publisher;
	
	@GetMapping("/publish/{message}")
	public ResponseEntity<?> publishMessage(@PathVariable String message){	
		
		try {
			
		for(int i=0;i<=1000;i++) {
			publisher.sendMessageToTopic(message +" "+ i);
		}
			return ResponseEntity.ok("Message published succesfully");
			
		}catch(Exception e){
			
			return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			
		}
	}
	
	 @PostMapping("/publish")
	    public void sendEvents(@RequestBody Customer customer) {
	        publisher.sendEventsToTopic(customer);
	    }

}
