package com.avaya.ccaas.participant_state_adapter.kafka.consumer;

import com.avaya.ccaas.participant_state_adapter.avro.ParticipantIdAvro;
import com.avaya.ccaas.participant_state_adapter.avro.ParticipantStateAvro;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.avro.generic.GenericRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Kafka consumer
 */
@Service
@AllArgsConstructor
@Slf4j
public class Receiver {

    @KafkaListener(topics = "${participant.topic}")
    public void receiveUpdatedAdvancedOrLdapSettings(GenericRecord message) {
        if (message.hasField("name")) {
            ParticipantStateAvro avro = new ParticipantStateAvro();
            avro.setId(message.get("id").toString());
            avro.setName(message.get("name").toString());
            log.info("Kafka message receiving success { " + avro.getId() + avro.getName() + " }");
        }else if (message.hasField("id")){
            ParticipantIdAvro avro = new ParticipantIdAvro();
            avro.setId(message.get("id").toString());
            log.info("Kafka message receiving success { " + avro.getId() + " }");
        } else {
            log.error("Receiving kafka message was failed");
        }
    }

}

