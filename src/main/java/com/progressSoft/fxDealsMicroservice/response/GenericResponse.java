package com.progressSoft.fxDealsMicroservice.response;

public class GenericResponse<T> {
    public static final String SUCCESS_STATUS = "Success";
    public static final String FAILED_STATUS = "Failed";

    private String status;
    private String message;
    private T data;

    // Constructors
    public GenericResponse() {
    }

    public GenericResponse(String status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // Getters and Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}