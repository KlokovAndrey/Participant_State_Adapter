package com.avaya.ccaas.participant_state_adapter.service;

import com.avaya.ccaas.participant_state_adapter.controller.exception.ParticipantInvalidException;
import com.avaya.ccaas.participant_state_adapter.model.Participant;
import com.avaya.ccaas.participant_state_adapter.validator.ParticipantValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ParticipantStateService {

    private final ParticipantValidator participantValidator;

    @Async
    public void add(Participant participant){
        validate(participant);
        //save();
    }

    @Async
    public void remove(String participantId){
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
