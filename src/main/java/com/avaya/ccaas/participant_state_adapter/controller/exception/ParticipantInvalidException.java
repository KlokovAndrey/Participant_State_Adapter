package com.avaya.ccaas.participant_state_adapter.controller.exception;

public class ParticipantInvalidException extends RuntimeException{

    public ParticipantInvalidException(String message){
        super(message);
    }
}
