package com.movix.developtest.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

    public EmployeeNotFoundException() {
    }

    public EmployeeNotFoundException(String s) {
        super(s);
    }

    public EmployeeNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
