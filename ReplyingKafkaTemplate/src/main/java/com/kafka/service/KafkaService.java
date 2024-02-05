package com.kafka.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.requestreply.ReplyingKafkaTemplate;
import org.springframework.kafka.requestreply.RequestReplyFuture;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class KafkaService {
    @Autowired
    private ReplyingKafkaTemplate<String, Object, Object> template;
    private String SEND_TOPICS="my-topics";

    public Object kafkaRequestReply(String request) throws Exception {
        ProducerRecord<String, Object> record = new ProducerRecord<>(SEND_TOPICS, "hiii","Bye");
        RequestReplyFuture<String, Object, Object> replyFuture = template.sendAndReceive(record);
        SendResult<String, Object> sendResult = replyFuture.getSendFuture().get(10, TimeUnit.SECONDS);
        ConsumerRecord<String, Object> consumerRecord = replyFuture.get(30, TimeUnit.SECONDS);
        return consumerRecord.value();
    }
}
