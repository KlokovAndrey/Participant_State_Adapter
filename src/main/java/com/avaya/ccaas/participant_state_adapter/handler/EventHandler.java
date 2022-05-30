package com.avaya.ccaas.participant_state_adapter.handler;

public interface EventHandler<T> {

    void handle(T t);
}
