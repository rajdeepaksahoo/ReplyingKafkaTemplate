package com.kafka;

import com.kafka.service.KafkaService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringKafkaClientApplicationTests {
	@Autowired
	KafkaService kafkaService;

	@Test
	void kafkaRequestReply_test() throws Exception {
		String request = "abcd123";
		String mustResponse = "321dcba";
		Object sendReply = kafkaService.kafkaRequestReply(request);
		String responseString = String.valueOf(sendReply);
		assertEquals(mustResponse, responseString);
		System.out.println(String.format("Request message: {}, Response message: {}", request, responseString));
	}
}