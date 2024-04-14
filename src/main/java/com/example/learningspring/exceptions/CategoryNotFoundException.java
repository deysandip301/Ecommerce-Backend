package com.example.learningspring.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    private Long id;
    public CategoryNotFoundException(Long id,String message) {
        super(message);
        this.id = id;
    }
}
