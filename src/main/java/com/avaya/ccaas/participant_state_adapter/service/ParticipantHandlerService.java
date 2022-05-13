package com.avaya.ccaas.participant_state_adapter.service;

import com.avaya.ccaas.participant_state_adapter.model.Participant;

public interface ParticipantHandlerService {

    void save(Participant participant);
    void delete(String participantId);
}
