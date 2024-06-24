package com.example.elastic_rest.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = PersonNotFoundException.class)
    ResponseEntity<Object> handlePersonNotFoundException(PersonNotFoundException e) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ExceptionResponsePayload responsePayload = new ExceptionResponsePayload(
                "Person Not Found",
                status,
                ZonedDateTime.now(ZoneId.of("UTC"))
        );
        return new ResponseEntity<>(responsePayload, status);
    }
}
