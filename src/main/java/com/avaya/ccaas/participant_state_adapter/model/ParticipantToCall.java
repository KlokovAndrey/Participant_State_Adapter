package com.avaya.ccaas.participant_state_adapter.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ParticipantToCall {
    private String callId;
    private String participantId;
}
