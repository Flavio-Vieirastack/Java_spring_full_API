package com.spring_full_api.spring_api.Resources.exceptions;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {

    private List<FieldMessage> list = new ArrayList<FieldMessage>();

    public ValidationError(Integer status, String message, Instant timeStamp) {
        super(status, message, timeStamp);
    }

    public List<FieldMessage> getErrors() {
        return list;
    }

    public void addError (String fieldName, String message){
        list.add(new FieldMessage(fieldName, message));
    }
    
}