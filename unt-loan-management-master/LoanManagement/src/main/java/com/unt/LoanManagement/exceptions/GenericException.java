package com.unt.LoanManagement.exceptions;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericException extends  RuntimeException{

    final Integer errorCode;

    final String statusCode;

    public GenericException(Integer errorCode, String statusCode) {
        super();
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public GenericException(String message, Integer errorCode, String statusCode) {
        super(message);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }

    public GenericException(String message, Throwable cause, Integer errorCode, String statusCode) {
        super(message, cause);
        this.errorCode = errorCode;
        this.statusCode = statusCode;
    }
}
