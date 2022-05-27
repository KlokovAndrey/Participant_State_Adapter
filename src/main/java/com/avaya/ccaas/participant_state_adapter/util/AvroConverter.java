package com.avaya.ccaas.participant_state_adapter.util;

public interface AvroConverter<T, D> {

    D pojoToAvro(T pojo);

    T avroToPojo(D avro);
}
