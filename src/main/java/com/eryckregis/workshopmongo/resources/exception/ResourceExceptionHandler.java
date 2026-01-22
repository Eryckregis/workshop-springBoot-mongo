package com.eryckregis.workshopmongo.resources.exception;

import com.eryckregis.workshopmongo.services.exception.objectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ResourceExceptionHandler  {

    @ExceptionHandler(objectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(objectNotFoundException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(),status.value(),"nao encontrado", e.getMessage(),request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }



}
