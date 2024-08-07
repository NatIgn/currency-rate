package com.egt.gateway.entity;

public class RequestAlreadyExistException extends RuntimeException{

    public RequestAlreadyExistException(String message) {
        super(message);
    }

    public RequestAlreadyExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestAlreadyExistException(Throwable cause) {
        super(cause);
    }
}
