package com.avaya.ccaas.participant_state_adapter.service.impl;

import com.avaya.ccaas.participant_state_adapter.avro.ParticipantIdAvro;
import com.avaya.ccaas.participant_state_adapter.avro.ParticipantStateAvro;
import com.avaya.ccaas.participant_state_adapter.kafka.producer.Sender;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.model.ParticipantToCall;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantHandlerService;
import com.avaya.ccaas.participant_state_adapter.util.ParticipantConverter;
import com.avaya.ccaas.participant_state_adapter.util.ParticipantIdConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Service
public class ParticipantHandlerServiceImpl implements ParticipantHandlerService {

    private final Sender sender;
    private final ParticipantConverter participantConverter;
    private final ParticipantIdConverter participantIdConverter;
    private @Value("${participant.topic}") String TOPIC;

    @Override
    public void add(Participant participant) {
        ParticipantStateAvro avro = participantConverter.pojoToAvro(participant);
        sender.send(TOPIC, participant.getCallId(), avro);
    }

    @Override
    public void remove(ParticipantToCall participantToCall) {
        ParticipantIdAvro avro = participantIdConverter.pojoToAvro(participantToCall);
        sender.send(TOPIC, participantToCall.getCallId(), avro);
    }
}
