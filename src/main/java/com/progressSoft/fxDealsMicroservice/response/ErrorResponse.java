package com.progressSoft.fxDealsMicroservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ErrorResponse {
    private Short statusCode;
    private String parameter;
    private Object message;

    // Constructors
    public ErrorResponse() {
    }

    public ErrorResponse(Short statusCode, String parameter, Object message) {
        this.statusCode = statusCode;
        this.parameter = parameter;
        this.message = message;
    }

    // Getters and Setters
    public Short getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Short statusCode) {
        this.statusCode = statusCode;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }
}