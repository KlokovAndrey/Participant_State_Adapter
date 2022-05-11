package com.avaya.ccaas.participant_state_adapter.controller;

import com.avaya.ccaas.participant_state_adapter.api.V1Api;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantStateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class ParticipantStateController implements V1Api {

    private final ParticipantStateService service;

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return V1Api.super.getRequest();
    }

    @Override
    public ResponseEntity<String> addParticipant(final Participant participant) {
        service.add(participant);
        return ResponseEntity.ok("");
    }

    @Override
    public ResponseEntity<String> removeParticipant(final String participantId) {
        service.remove(participantId);
        return ResponseEntity.ok("");
    }
}
