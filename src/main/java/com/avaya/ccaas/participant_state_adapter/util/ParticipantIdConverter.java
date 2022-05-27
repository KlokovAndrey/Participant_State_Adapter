package com.avaya.ccaas.participant_state_adapter.util;

import com.avaya.ccaas.participant_state_adapter.avro.ParticipantIdAvro;
import com.avaya.ccaas.participant_state_adapter.model.ParticipantToCall;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ParticipantIdConverter implements AvroConverter<ParticipantToCall, ParticipantIdAvro>{
    @Override
    public ParticipantIdAvro pojoToAvro(final ParticipantToCall pojo) {
        ParticipantIdAvro avro = new ParticipantIdAvro();
        avro.setId(pojo.getParticipantId());
        avro.setCallId(pojo.getCallId());
        return avro;
    }

    @Override
    public ParticipantToCall avroToPojo(final ParticipantIdAvro avro) {
        ParticipantToCall pojo = new ParticipantToCall(avro.getId().toString(),
            avro.getCallId().toString());
        return pojo;
    }
}
