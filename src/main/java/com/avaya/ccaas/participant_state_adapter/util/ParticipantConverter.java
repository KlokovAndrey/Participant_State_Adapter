package com.avaya.ccaas.participant_state_adapter.util;

import com.avaya.ccaas.participant_state_adapter.avro.ParticipantStateAvro;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.Decoder;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.io.Encoder;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

@Component
public class ParticipantConverter implements AvroConverter<Participant, ParticipantStateAvro>{

    @Override
    public ParticipantStateAvro pojoToAvro(final Participant pojo) {
        ParticipantStateAvro avro = new ParticipantStateAvro();
        avro.setId(pojo.getId());
        avro.setCallId(pojo.getCallId());
        avro.setName(pojo.getName());
        return avro;
    }

    @Override
    public Participant avroToPojo(final ParticipantStateAvro avro) {
        Participant participant = new Participant();
        participant.setId(avro.getId().toString());
        participant.setCallId(avro.getCallId().toString());
        participant.setName(avro.getName().toString());
        return participant;
    }

    public byte[] serialize(final Participant pojo) {
        byte[] data = new byte[0];
        ParticipantStateAvro avro = new ParticipantStateAvro(pojo.getId(), pojo.getCallId(), pojo.getName());
        DatumWriter<ParticipantStateAvro> writer = new SpecificDatumWriter<>(
            ParticipantStateAvro.class);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        Encoder jsonEncoder = null;
        try {
            jsonEncoder = EncoderFactory.get().jsonEncoder(
                ParticipantStateAvro.getClassSchema(), stream);
            writer.write(avro, jsonEncoder);
            jsonEncoder.flush();
            data = stream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    public Participant deserialize(final byte[] data) {
        Participant participant = null;
        DatumReader<ParticipantStateAvro> reader
            = new SpecificDatumReader<>(ParticipantStateAvro.class);
        Decoder decoder = null;
        try {
            decoder = DecoderFactory.get().jsonDecoder(
                ParticipantStateAvro.getClassSchema(), new String(data));
            ParticipantStateAvro avro = reader.read(null, decoder);
            participant = new Participant();
            participant.setId(avro.getId().toString());
            participant.setCallId(avro.getCallId().toString());
            participant.setName(avro.getName().toString());
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
        }
        return participant;
    }
}
