package com.Jbertoni.Todolist.Exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    
    private static final Logger logger = LogManager.getLogger(ExceptionHandlerAdvice.class);

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<String> handleException(TaskNotFoundException e) {
        String msg = e.getMessage();

        logger.error(msg);
        
        ResponseEntity<String> responseEntity;
        responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);

        return responseEntity;
    }
}