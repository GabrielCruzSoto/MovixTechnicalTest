package com.movix.developtest.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class JSONResponse<T> {

    private ResponseStatus status;
    private T result;

    public JSONResponse() {
        super();
    }

    public JSONResponse(ResponseStatus status, T result) {
        this.status = status;
        this.result = result;
    }

    public JSONResponse(ResponseStatus status) {
        this.status = status;
    }

    public ResponseStatus getStatus() {
        return this.status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public T getResult() {
        return this.result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
