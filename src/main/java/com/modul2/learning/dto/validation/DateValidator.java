package com.modul2.learning.dto.validation;

import com.tenis.challenge.dto.ChallengeCreateDTO;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, ChallengeCreateDTO> {
    @Override
    public void initialize(ValidDate validDate) {
    }

    @Override
    public boolean isValid(ChallengeCreateDTO challengeCreateDTO, ConstraintValidatorContext context) {
        return !challengeCreateDTO.getMatchStartDate().isAfter(challengeCreateDTO.getMatchEndDate());
    }
}
