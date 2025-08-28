package com.service.restaurantService.common.infraestructure.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ErrorResponse {
    public LocalDateTime timestamp = LocalDateTime.now();
    public int status;
    public String error;
    public String message;
    public String path;
    public Map<String,String> errors;

    public ErrorResponse() {}
    public ErrorResponse(int status, String error, String message, String path){
        this.status = status;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
