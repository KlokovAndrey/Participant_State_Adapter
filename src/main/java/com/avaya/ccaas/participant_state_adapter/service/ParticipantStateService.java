package com.avaya.ccaas.participant_state_adapter.service;

import com.avaya.ccaas.participant_state_adapter.model.Participant;

public interface ParticipantStateService {

    void add(Participant participant);
    void remove(String participantId);
}
