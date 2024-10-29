package com.unt.LoanManagement.exceptions;

public class NotFoundException extends  RuntimeException{

    final String errorMessage;
    public NotFoundException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public NotFoundException(String message, String errorMessage) {
        super(message);
        this.errorMessage = errorMessage;
    }

    public NotFoundException(String message, Throwable cause, String errorMessage) {
        super(message, cause);
        this.errorMessage = errorMessage;
    }

}
