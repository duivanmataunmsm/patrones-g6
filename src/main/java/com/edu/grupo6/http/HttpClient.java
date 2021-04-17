package com.edu.grupo6.http;

import com.edu.grupo6.interceptingFilter.FilterManager;


public class HttpClient {
    private FilterManager filterManager;

    public HttpClient(FilterManager filterManager) {
        this.filterManager = filterManager;
    }

    public HTTPResponse submit(HTTPRequest request) {
        HTTPResponse response = filterManager.execute(request);
        return response;
    }
}
