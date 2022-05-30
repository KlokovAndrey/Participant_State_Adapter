package com.avaya.ccaas.participant_state_adapter.handler;

import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantHandlerService;
import com.avaya.ccaas.participant_state_adapter.service.RunAsyncService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AddParticipantCommandHandler implements EventHandler<Participant>{

    private final RunAsyncService runAsyncService;
    private final ParticipantHandlerService service;

    @Override
    public void handle(final Participant participant) {
        runAsyncService.run(() -> service.add(participant));
    }
}
