package com.avaya.ccaas.participant_state_adapter.service;

import com.avaya.ccaas.participant_state_adapter.kafka.producer.Sender;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.util.ParticipantConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ParticipantHandlerServiceImpl implements ParticipantHandlerService{

    private final Sender sender;
    private final ParticipantConverter converter;
    private String TOPIC = "ParticipantState";

    @Override
    public void save(final Participant participant) {
        byte[] message = converter.pojoToAvro(participant);
        System.out.println(converter.avroToPojo(message).toString());
        sender.send(TOPIC, message);
    }

    @Override
    public void delete(final String participantId) {
        //sender.send(TOPIC, participantId);
    }
}
