package com.avaya.ccaas.participant_state_adapter.handler;

import com.avaya.ccaas.participant_state_adapter.model.ParticipantToCall;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantHandlerService;
import com.avaya.ccaas.participant_state_adapter.service.RunAsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class RemoveParticipantCommandHandler implements EventHandler<ParticipantToCall> {

    private final RunAsyncService runAsyncService;
    private final ParticipantHandlerService service;

    @Override
    public void handle(final ParticipantToCall participantToCall) {
        runAsyncService.run(() -> service.remove(participantToCall));
    }
}
