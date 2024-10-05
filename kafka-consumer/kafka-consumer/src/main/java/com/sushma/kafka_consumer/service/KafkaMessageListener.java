package com.sushma.kafka_consumer.service;

//import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListener {

	Logger log=LoggerFactory.getLogger(KafkaMessageListener.class);
	
	
	@KafkaListener(topics ="sushma-demo-topic-3",groupId="jt-group-1")
	public void consume1(String message) {
		
		log.info("consumer1 is consuming the message", message);
		
	}
	
	@KafkaListener(topics ="sushma-demo-topic-3",groupId="jt-group-1")
	public void consume2(String message) {
		
		log.info("consumer2 is consuming the message", message);
		
	}
	
	@KafkaListener(topics ="sushma-demo-topic-3",groupId="jt-group-1")
	public void consume3(String message) {
		
		log.info("consumer3 is consuming the message", message);
		
	}
	
	@KafkaListener(topics ="sushma-demo-topic-3",groupId="jt-group-1")
	public void consume4(String message) {
		
		log.info("consumer4 is consuming the message", message);
		
	}
}
