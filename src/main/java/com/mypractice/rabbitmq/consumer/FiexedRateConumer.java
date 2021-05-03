package com.mypractice.rabbitmq.consumer;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class FiexedRateConumer {
	@RabbitListener(queues = "fixedrate.queue", concurrency = "3-7")
	public void listen(String message) throws InterruptedException {
		TimeUnit.MILLISECONDS.sleep(ThreadLocalRandom.current().nextLong(1000, 2000));
		System.out.println(Thread.currentThread().getName()+" FiexedRateConumer.listen() : [" + message + "]");
	}
}
