package com.mypractice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.rabbitmq.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class FanoutConsumer {
	
	private final ObjectMapper objMapper;
	@Autowired
	public FanoutConsumer(ObjectMapper objMapper) {
		super();
		this.objMapper = objMapper;
	}

	@RabbitListener(queues = "queue.hr.marketing")
	public void getAccountMessages(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		log.info("user accounting messages {}",user);
	}
	
	@RabbitListener(queues = "queue.hr.accounting")
	public void  getMarketingMessages(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		log.info("user marketing messages {}",user);
	}
	
}
