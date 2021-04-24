package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.http.HTTPRequest;
import com.edu.grupo6.http.HTTPResponse;
import com.edu.grupo6.interfaces.IFilter;

import java.util.ArrayList;
import java.util.Iterator;

public class FilterChain {
    private ArrayList<IFilter> filters;
    private Target target;
    private Iterator<IFilter> iterator;

    public FilterChain(Target target) {
        this.target = target;
        filters = new ArrayList<>();
        iterator = filters.iterator();
    }
    public void addFilter(IFilter filter) {
        filters.add(filter);
        iterator = filters.iterator();
    }
    public void doFilter(HTTPRequest request, HTTPResponse response) {
        if(iterator.hasNext()) { // Si tengo un filtro pendiente, lo llamo
            iterator.next().doFilter(request, response, this);
        } else {
            target.execute(request, response);
        }
    }
}
