package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.interfaces.IFilter;

import java.util.ArrayList;

public class FilterManager {
    ArrayList<IFilter> filterChain;


    public FilterManager() {
        filterChain = new ArrayList<>();
    }

    public HTTPResponse execute(HTTPRequest request) {
        HTTPResponse response = new HTTPResponse();

        FilterChain filterChain = new FilterChain(new Target()); // Se procesa el request y se establece el destino

        filterChain.addFilter(new AuthenticationFilter()); // Siempre se aplica este filtro
        if ("api".equals(request.getPath(0))) { //
            filterChain.addFilter(new TimeFilter());
        }

        filterChain.doFilter(request, response); // Se pasa el control

        return response;
    }
}
