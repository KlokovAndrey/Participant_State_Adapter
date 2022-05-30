package com.avaya.ccaas.participant_state_adapter.kafka.producer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@RequiredArgsConstructor
@Component
@Slf4j
public class Sender {

    private final KafkaTemplate<String, GenericRecord> kafkaTemplate;
    private ListenableFutureCallback<SendResult<String, GenericRecord>> callback =
        new ListenableFutureCallback<SendResult<String, GenericRecord>>() {
        @Override
        public void onSuccess(SendResult<String, GenericRecord> result) {
            log.info("Message has been sent successfully");
        }

        @Override
        public void onFailure(Throwable ex) {
            log.error("unable to send message");
        }
    };

    public void send(String topic, String messageId, GenericRecord message) {
        log.info("Sending message {} to the Kafka", message);
        try {
            ListenableFuture<SendResult<String, GenericRecord>> future = kafkaTemplate.send(topic, messageId, message);
            future.addCallback(callback);
        } catch (Exception exception){
            log.error(exception.getMessage());
        }
    }
}