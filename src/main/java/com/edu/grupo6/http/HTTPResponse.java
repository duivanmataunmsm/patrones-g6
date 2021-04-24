package com.edu.grupo6.http;

public class HTTPResponse<T> {
    HTTPStatus statusCode;
    //Headers headers;
    //URI uri
    T body;

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public HTTPStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HTTPStatus statusCode) {
        this.statusCode = statusCode;
    }

}
