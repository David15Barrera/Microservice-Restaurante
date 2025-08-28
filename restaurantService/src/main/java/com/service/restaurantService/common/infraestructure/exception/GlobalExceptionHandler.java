package com.service.restaurantService.common.infraestructure.exception;


import com.service.restaurantService.common.aplication.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.stream.Collectors;

public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(ResourceNotFoundException ex, WebRequest req){
        ErrorResponse r = new ErrorResponse(HttpStatus.NOT_FOUND.value(), "Not Found", ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(r, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ErrorResponse> validation(ValidationException ex, WebRequest req){
        ErrorResponse r = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed", ex.getMessage(), req.getDescription(false));
        r.errors = ex.getErrors();
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodValid(MethodArgumentNotValidException ex, WebRequest req){
        Map<String,String> map = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage, (a,b)->a));
        ErrorResponse r = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Validation Failed", "Request validation failed", req.getDescription(false));
        r.errors = map;
        return new ResponseEntity<>(r, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ErrorResponse> app(ApplicationException ex, WebRequest req){
        ErrorResponse r = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Application Error", ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> other(Exception ex, WebRequest req){
        ErrorResponse r = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Error", ex.getMessage(), req.getDescription(false));
        return new ResponseEntity<>(r, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
