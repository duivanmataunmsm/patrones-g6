package com.edu.grupo6.http;

public class HTTPRequest<T> {
    HTTPMethod method;
    String path;
    T body;

    public HTTPMethod getMethod() {
        return method;
    }

    public void setMethod(HTTPMethod method) {
        this.method = method;
    }

    public String getPath(int order) {
        return this.path.split("/")[order + 1];
    }

    public void setPath(String path) {
        this.path = path;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

}
