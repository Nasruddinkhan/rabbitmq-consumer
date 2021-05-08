package com.mypractice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mypractice.rabbitmq.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class TopicConsumer {
	int counter = 0;
	private final ObjectMapper objMapper;

	@Autowired
	public TopicConsumer(ObjectMapper objMapper) {
		super();
		this.objMapper = objMapper;
	}

	@RabbitListener(queues = { "q.doctype.profile", "q.doctype.pdf", "q.doctype.word", "q.doctype.large","q.doctype.xlx" })
	public void getAccountMessages(String message) throws Exception {
		User user = objMapper.readValue(message, User.class);
		counter++;
		log.info(counter + " user " + user.getDocType() + " messages {}", user);
	}

}
