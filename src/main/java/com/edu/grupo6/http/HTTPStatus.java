package com.edu.grupo6.http;

public enum HTTPStatus {
    OK(200), BAD_REQUEST(400), UNAUTHORIZED(401), NOT_FOUND(404), CONFLICT(409), INTERNAL_SERVER_ERROR(500);

    private int code;

    HTTPStatus(int code) {
        this.code = code;
    }
    public boolean isError() {
        return this.code >= 400;
    }

    @Override
    public String toString() {
        return "HTTP/2.0 " + this.code + ' ' + super.toString() + ' ';
    }
}
