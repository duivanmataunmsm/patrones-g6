package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.http.HTTPStatus;

public class Target {

    public void execute(HTTPRequest request, HTTPResponse response) {
        response.setStatusCode(HTTPStatus.OK);
    }
}
