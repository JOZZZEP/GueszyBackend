package com.example.gueszybackend.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class BaseException extends Exception {
    private final HttpStatus httpStatus;

    protected BaseException(String code){
        super(code);
        this.httpStatus = HttpStatus.EXPECTATION_FAILED;
    }

    protected BaseException(String code, HttpStatus httpStatus) {
        super(code);
        this.httpStatus = httpStatus;
    }

}
