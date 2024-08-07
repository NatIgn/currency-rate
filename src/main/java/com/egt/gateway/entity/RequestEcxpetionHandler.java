package com.egt.gateway.entity;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RequestEcxpetionHandler {
    @ExceptionHandler
    public ResponseEntity<RequestError> handleException(RequestAlreadyExistException exc) {
        RequestError requestError = new RequestError();
        requestError.setStatus(HttpStatus.CONFLICT.value());
        requestError.setMessage(exc.getMessage());
        requestError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(requestError, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<NoResultsError> handleNoResultsException(NoResultsFoundException exc) {
        NoResultsError noResultsError = new NoResultsError();
        noResultsError.setStatus(HttpStatus.NOT_FOUND.value());
        noResultsError.setMessage(exc.getMessage());
        noResultsError.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(noResultsError, HttpStatus.NOT_FOUND);
    }
}
