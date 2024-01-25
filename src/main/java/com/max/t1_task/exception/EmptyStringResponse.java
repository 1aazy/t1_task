package com.max.t1_task.exception;

public class EmptyStringResponse {
    private String message;

    public EmptyStringResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
