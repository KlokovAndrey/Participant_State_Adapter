package com.avaya.ccaas.participant_state_adapter.kafka.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Sender {

    @Autowired
    private KafkaTemplate<String, byte[]> kafkaTemplate;

    public void send(String topic, byte[] message) {
        ListenableFuture<SendResult<String, byte[]>> future = kafkaTemplate.send(topic, message);
        future.addCallback(new ListenableFutureCallback<SendResult<String, byte[]>>() {

            @Override
            public void onSuccess(SendResult<String, byte[]> result) {
                System.out.println("sent message='{" + message + "}' with offset={" +
                    result.getRecordMetadata().offset() + "}");
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("unable to send message='{" + message + "}");
            }
        });
    }
}