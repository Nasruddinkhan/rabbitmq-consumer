package com.mypractice.rabbitmq.consumer;

import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.rabbitmq.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserConsumer {
	
	private final ObjectMapper objMapper;
	@Autowired
	public UserConsumer(ObjectMapper objMapper) {
		super();
		this.objMapper = objMapper;
	}

	@RabbitListener(queues = "user.queue")
	public void sendMessages(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		log.info("user ->{}",user);
	}
	
}
