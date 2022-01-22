package com.spring_full_api.spring_api.Service.exceptions;


public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException (String msg) {
        super(msg);
    }

    public ObjectNotFoundException(String msg, Throwable cause) {
        super(msg, cause);
    }
}