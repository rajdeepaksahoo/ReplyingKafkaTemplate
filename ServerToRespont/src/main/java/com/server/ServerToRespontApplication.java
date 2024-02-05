package com.server;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;

import java.util.concurrent.Future;

@SpringBootApplication
@EnableKafka
public class ServerToRespontApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerToRespontApplication.class, args);
	}
	@KafkaListener(topics = "my-topics",groupId = "asas")
	@SendTo
	public Message<?> listen(Object o){
		System.out.println("Received Data : "+o);
		ProducerRecord<String,String> record = new ProducerRecord<>("my-topics-reply","HI","BYE");
		return MessageBuilder.withPayload("Received").build();
	}
}
