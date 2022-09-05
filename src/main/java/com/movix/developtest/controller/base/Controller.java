package com.movix.developtest.controller.base;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.movix.developtest.dto.JSONResponse;
import com.movix.developtest.dto.ResponseStatus;

public class Controller {

    public <T> ResponseEntity<JSONResponse> buildOkStatusResponse(T responseData) {
        ResponseStatus responseStatus = new ResponseStatus(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase());
        JSONResponse<T> jsonResponse = new JSONResponse<>(responseStatus, responseData);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }

    public <T> ResponseEntity<JSONResponse> buildStatusResponse(Exception e, HttpStatus status) {
        ResponseStatus responseStatus = new ResponseStatus(status.value(), e.getMessage());
        JSONResponse<T> jsonResponse = new JSONResponse<>(responseStatus);
        return new ResponseEntity<>(jsonResponse, HttpStatus.OK);
    }
}
