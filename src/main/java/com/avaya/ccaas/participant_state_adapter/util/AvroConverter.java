package com.avaya.ccaas.participant_state_adapter.util;

import com.avaya.ccaas.participant_state_adapter.model.Participant;

public interface AvroConverter<T> {

    byte[] pojoToAvro(T pojo);

    T avroToPojo(byte[] data);
}
