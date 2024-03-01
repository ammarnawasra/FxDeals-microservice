package com.progressSoft.fxDealsMicroservice.validator;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorBuilder {

    private final List<ValidationError> errors = new ArrayList<>();

    public ValidationErrorBuilder addError(String errorCode) {
        return addError(errorCode, new Object[]{});
    }

    public ValidationErrorBuilder addError(String errorCode, Object... args) {
        ValidationError validationError = new ValidationError(errorCode,args);
        errors.add(validationError);
        return this;
    }

    public List<ValidationError> build() {
        return new ArrayList<>(errors);
    }
}