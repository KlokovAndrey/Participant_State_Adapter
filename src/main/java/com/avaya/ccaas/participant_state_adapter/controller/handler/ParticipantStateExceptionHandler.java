package com.avaya.ccaas.participant_state_adapter.controller.handler;

import com.avaya.ccaas.participant_state_adapter.controller.exception.ParticipantInvalidException;
import com.avaya.ccaas.participant_state_adapter.controller.exception.ParticipantNotFoundException;
import com.avaya.ccaas.participant_state_adapter.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice
public class ParticipantStateExceptionHandler {

    @ExceptionHandler(ParticipantNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleParticipantNotFoundException(ParticipantNotFoundException exception){
        return new ErrorResponse();
    }

    @ExceptionHandler(ParticipantInvalidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleParticipantInvalidException(ParticipantInvalidException exception) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(exception.getMessage());
        return errorResponse;
    }
}
