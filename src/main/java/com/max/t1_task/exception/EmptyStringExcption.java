package com.max.t1_task.exception;

public class EmptyStringExcption extends RuntimeException {
    public EmptyStringExcption() {
        super();
    }

    public EmptyStringExcption(String message) {
        super(message);
    }

    public EmptyStringExcption(String message, Throwable cause) {
        super(message, cause);
    }
}
