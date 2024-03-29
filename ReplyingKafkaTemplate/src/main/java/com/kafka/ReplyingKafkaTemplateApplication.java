package com.kafka;

import com.kafka.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableKafka
@RestController
public class ReplyingKafkaTemplateApplication {
	@Autowired
	KafkaService kafkaService;
	@GetMapping("/")
	public Object send() throws Exception {
		return kafkaService.kafkaRequestReply("");

	}
	public static void main(String[] args) {
		SpringApplication.run(ReplyingKafkaTemplateApplication.class, args);
	}

}
