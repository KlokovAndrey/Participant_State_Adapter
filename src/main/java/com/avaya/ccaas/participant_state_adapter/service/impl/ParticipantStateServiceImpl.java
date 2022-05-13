package com.avaya.ccaas.participant_state_adapter.service.impl;

import com.avaya.ccaas.participant_state_adapter.controller.exception.ParticipantInvalidException;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantHandlerService;
import com.avaya.ccaas.participant_state_adapter.service.ParticipantStateService;
import com.avaya.ccaas.participant_state_adapter.validator.ParticipantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiredArgsConstructor
@Service
public class ParticipantStateServiceImpl implements ParticipantStateService {

    private final ParticipantValidator participantValidator;
    private final ParticipantHandlerService participantHandlerService;
    private ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void add(Participant participant){
        validate(participant);
        CompletableFuture.runAsync(() -> participantHandlerService.save(participant),
            executorService);
    }

    @Override
    public void remove(String participantId){
        CompletableFuture.runAsync(() -> participantHandlerService.delete(participantId),
            executorService);
    }

    private void validate(Participant participant){
        DataBinder dataBinder = new DataBinder(participant);
        dataBinder.addValidators(participantValidator);
        dataBinder.validate();
        if(dataBinder.getBindingResult().hasErrors()){
            throw new ParticipantInvalidException(dataBinder.getBindingResult().getAllErrors().toString());
        }
    }
}
