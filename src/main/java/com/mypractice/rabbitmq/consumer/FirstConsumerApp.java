package com.mypractice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FirstConsumerApp {
	@RabbitListener(queues = "firstapp.queue")
	public void listen(String message) {
		System.out.println("FirstConsumerApp.listen() : ["+message+"]");
	}
}
