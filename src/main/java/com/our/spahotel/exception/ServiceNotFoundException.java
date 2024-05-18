package com.our.spahotel.exception;

import lombok.Getter;

@Getter
public class ServiceNotFoundException extends RuntimeException{
    private String resource;
    private String property;
    private String propertyValue;

    public ServiceNotFoundException(String resource, String property, String propertyValue) {
        super("Not found " + resource + " with " + property + " = " + propertyValue);
        this.resource = resource;
        this.property = property;
        this.propertyValue = propertyValue;
    }
}