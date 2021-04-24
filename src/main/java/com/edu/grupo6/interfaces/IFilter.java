package com.edu.grupo6.interfaces;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.interceptingFilter.FilterChain;

public interface IFilter {
    public void doFilter(HTTPRequest request, HTTPResponse response, FilterChain filterChain);
}
