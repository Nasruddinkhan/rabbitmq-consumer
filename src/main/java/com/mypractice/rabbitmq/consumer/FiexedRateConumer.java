package com.mypractice.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FiexedRateConumer {
	@RabbitListener(queues = "fixedrate.queue")
	public void listen(String message) {
		System.out.println("FiexedRateConumer.listen() : ["+message+"]");
	}
}
