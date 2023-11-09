package com.finalproject.exception;

public class ValidationErrorResponse {
    private String error;

    public ValidationErrorResponse(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
