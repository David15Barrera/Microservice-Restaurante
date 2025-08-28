package com.service.restaurantService.common.aplication.exception;

import java.util.Map;

public class ValidationException extends ApplicationException {
    private Map<String,String> errors;

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Map<String,String> errors) {
        super(message); this.errors = errors;
    }

    public Map<String,String> getErrors(){
        return errors;
    }
}