package com.example.elastic_rest.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public record ExceptionResponsePayload (String message, HttpStatus status, ZonedDateTime dateTime){
}
