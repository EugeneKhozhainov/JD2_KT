package com.itacademy.exception;

import lombok.Getter;

@Getter
public class ValidatorException extends RuntimeException {

    private String error;

    public ValidatorException() {}

    public ValidatorException(String error) {
        super(error);
        this.error = error;
    }

    public ValidatorException(Exception e) {
        super(e.toString());
        this.error = e.toString();
    }

}

