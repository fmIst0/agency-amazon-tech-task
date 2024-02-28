package com.example.amazonagencytechtask.exception;

public class DataBaseNotFoundException extends RuntimeException {
    public DataBaseNotFoundException(String message) {
        super(message);
    }

    public DataBaseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
