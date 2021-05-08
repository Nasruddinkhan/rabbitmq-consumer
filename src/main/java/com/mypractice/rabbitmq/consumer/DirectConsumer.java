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
public class DirectConsumer {
	
	private final ObjectMapper objMapper;
	@Autowired
	public DirectConsumer(ObjectMapper objMapper) {
		super();
		this.objMapper = objMapper;
	}

	@RabbitListener(queues = "q.permanent.emp")
	public void getPermanetEmployee(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		log.info("permanent employees  {}",user);
	}
	
	@RabbitListener(queues = "q.contract.emp")
	public void  getContractEmployee(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		log.info("contract employees {}",user);
	}
	
}
