package com.our.spahotel.exception;

import lombok.Getter;

@Getter
public class AppointmentNotFoundException extends RuntimeException{
    private String resource;
    private String property;
    private String propertyValue;

    public AppointmentNotFoundException(String resource, String property, String propertyValue) {
        super("Not found " + resource + " with " + property + " = " + propertyValue);
        this.resource = resource;
        this.property = property;
        this.propertyValue = propertyValue;
    }
}
