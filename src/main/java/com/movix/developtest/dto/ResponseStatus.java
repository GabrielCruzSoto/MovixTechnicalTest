package com.movix.developtest.dto;

public class ResponseStatus {

    private int code;
    private String description;

    public ResponseStatus() {
        super();
    }

    public ResponseStatus(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ResponseStatus{" + "code=" + this.code + ", description='" + this.description + '\'' + '}';
    }
}
