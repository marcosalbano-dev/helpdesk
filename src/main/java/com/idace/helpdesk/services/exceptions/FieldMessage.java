package com.idace.helpdesk.services.exceptions;

import java.io.Serializable;

public class FieldMessage implements Serializable {

    private String fieldMessage;
    private String message;


    public FieldMessage() {
        super();
    }

    public FieldMessage(String fielMessage, String message) {
        this.fieldMessage = fielMessage;
        this.message = message;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String fieldMessage) {
        this.fieldMessage = fieldMessage;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
