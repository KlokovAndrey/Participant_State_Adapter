package com.avaya.ccaas.participant_state_adapter.service;

import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.model.ParticipantToCall;

public interface ParticipantHandlerService {

    void add(Participant participant);
    void remove(ParticipantToCall participantToCall);
}
