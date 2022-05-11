package com.avaya.ccaas.participant_state_adapter.validator;

import com.avaya.ccaas.participant_state_adapter.model.Participant;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ParticipantValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return clazz.equals(Participant.class);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        Participant participant = (Participant) target;
        ValidationUtils.rejectIfEmpty(errors, "id", "id.empty");
        ValidationUtils.rejectIfEmpty(errors, "name", "name.empty");
    }
}
