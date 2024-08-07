package com.egt.gateway.entity;

public class NoResultsFoundException extends RuntimeException{

    public NoResultsFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResultsFoundException(String message) {
        super(message);
    }

    public NoResultsFoundException(Throwable cause) {
        super(cause);
    }
}
