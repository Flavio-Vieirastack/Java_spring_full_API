package com.spring_full_api.spring_api.Service.exceptions;


public class DataIntegrityException extends RuntimeException{
    public DataIntegrityException (String msg) {
        super(msg);
    }

    public DataIntegrityException(String msg, Throwable cause) {
        super(msg, cause);
    }
}