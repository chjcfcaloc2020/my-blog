package com.chjcfcaloc2020.my_blog.exception.payload;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
