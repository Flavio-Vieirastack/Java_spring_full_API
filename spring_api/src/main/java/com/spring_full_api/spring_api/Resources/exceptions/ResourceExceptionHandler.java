package com.spring_full_api.spring_api.Resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import com.spring_full_api.spring_api.Service.exceptions.ObjectNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(
        ObjectNotFoundException e, HttpServletRequest request
        ) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), Instant.now());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }
}