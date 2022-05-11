package com.avaya.ccaas.participant_state_adapter.controller.exception;

public class ParticipantNotFoundException extends RuntimeException{
    public ParticipantNotFoundException(){
        super("Participant was not found");
    }
}
