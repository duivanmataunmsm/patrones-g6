package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.http.HTTPStatus;
import com.edu.grupo6.interfaces.IFilter;

/**
 * Filtro para validar la hora en la que se hace el request
 */
public class TimeFilter implements IFilter {
    int time = 10;

    @Override
    public void doFilter(HTTPRequest request, HTTPResponse response, FilterChain filterChain) {
        // TODO: validar la hora del request
        if(time > 12) {
            response.setStatusCode(HTTPStatus.UNAUTHORIZED);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
