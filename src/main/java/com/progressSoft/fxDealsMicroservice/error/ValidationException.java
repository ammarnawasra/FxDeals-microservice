package com.progressSoft.fxDealsMicroservice.error;

import com.progressSoft.fxDealsMicroservice.validator.ValidationError;

import java.util.List;

public class ValidationException extends RuntimeException {

    private final List<ValidationError> validationErrors;

    public ValidationException(String message, List<ValidationError> validationErrors) {
        super(message);
        this.validationErrors = validationErrors;
    }

    public List<ValidationError> getValidatorErrors() {
        return validationErrors;
    }
}