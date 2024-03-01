package com.progressSoft.fxDealsMicroservice.validator;

public class ValidationError {

    private final String errorKey;
    private final Object[] arguments;

    public ValidationError(String errorKey, Object[] arguments) {
        this.errorKey = errorKey;
        this.arguments = arguments;
    }

    public String getErrorKey() {
        return errorKey;
    }

    public Object[] getArguments() {
        return arguments;
    }
}