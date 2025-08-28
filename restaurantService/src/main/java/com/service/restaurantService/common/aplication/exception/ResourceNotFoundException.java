package com.service.restaurantService.common.aplication.exception;

public class ResourceNotFoundException extends ApplicationException {

    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}