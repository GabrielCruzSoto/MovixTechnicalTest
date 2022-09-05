package com.movix.developtest.controller;

import com.movix.developtest.controller.base.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.movix.developtest.dto.JSONResponse;
import com.movix.developtest.exceptions.EmployeeNotFoundException;

@ControllerAdvice
public class ExceptionsControllerAdvice extends Controller {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionsControllerAdvice.class);

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity<JSONResponse> genericException(Exception e) {
        logger.error("InternalServerERROR|genericException message={}", e.getMessage(), e);
        return this.buildStatusResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = EmployeeNotFoundException.class)
    @ResponseBody
    public ResponseEntity<JSONResponse> notFoundExceptions(EmployeeNotFoundException e) {
        logger.error("notFoundExceptions|not found. message={}", e.getMessage(), e);
        return this.buildStatusResponse(e, HttpStatus.NOT_FOUND);
    }
}