package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.http.HTTPSession;
import com.edu.grupo6.http.HTTPStatus;
import com.edu.grupo6.interfaces.IFilter;

public class AuthenticationFilter implements IFilter {

    @Override
    public void doFilter(HTTPRequest request, HTTPResponse response, FilterChain filterChain) {
        HTTPSession session = HTTPSession.getInstance();
        if (session.isUserAuthenticated()) {
            filterChain.doFilter(request, response); // si esta autorizado se continua con la cadena de filtros
        } else {
            // se aborta la cadena de filtros
            response.setStatusCode(HTTPStatus.UNAUTHORIZED);
        }
    }
}
