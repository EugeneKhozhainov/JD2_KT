package com.itacademy.exception;

import lombok.Getter;

@Getter
public class SystemException extends RuntimeException {

    private String error;

    public SystemException() {}

    public SystemException(String error) {
        super(error);
        this.error = error;
    }

    public SystemException(Exception e) {
        super(e.toString());
        this.error = e.toString();
    }

}

