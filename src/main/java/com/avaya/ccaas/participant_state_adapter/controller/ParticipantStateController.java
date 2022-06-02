package com.avaya.ccaas.participant_state_adapter.controller;

import com.avaya.ccaas.participant_state_adapter.api.V1Api;
import com.avaya.ccaas.participant_state_adapter.handler.AddParticipantCommandHandler;
import com.avaya.ccaas.participant_state_adapter.handler.RemoveParticipantCommandHandler;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.model.ParticipantToCall;
import com.avaya.ccaas.participant_state_adapter.validator.ParticipantValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ParticipantStateController implements V1Api {

    private final ParticipantValidator participantValidator;
    private final AddParticipantCommandHandler addParticipantCommandHandler;
    private final RemoveParticipantCommandHandler removeParticipantCommandHandler;


    private void initBinder(WebDataBinder binder){
        binder.setValidator(participantValidator);
    }

    @Override
    public ResponseEntity<String> addParticipant(@Valid Participant participant) {
        log.info("Request to add participant {} received", participant);
        addParticipantCommandHandler.handle(participant);
        return ResponseEntity.ok("");
    }

    @Override
    public ResponseEntity<String> removeParticipant(@Valid String callId, @Valid String participantId) {
        log.info("Request to remove participant id={} received", participantId);
        removeParticipantCommandHandler.handle(new ParticipantToCall(callId, participantId));
        return ResponseEntity.ok("");
    }
}
