package com.edu.grupo6.interceptingFilter;

import com.edu.grupo6.ImageSingleton;
import com.edu.grupo6.http.*;
import com.edu.grupo6.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InterceptingFilterTest {
    private HttpClient http;

    @BeforeEach
    void before() {
        http = new HttpClient(new FilterManager());
    }
    @Test
    public void shouldFilterUnauthorized() {
        HTTPRequest<User> request = new HTTPRequest<>();
        request.setBody(new User());
        request.setMethod(HTTPMethod.GET);
        request.setPath("/api/v1/user");
        HTTPResponse<User> response = this.http.submit(request);
        Assertions.assertEquals(HTTPStatus.UNAUTHORIZED,response.getStatusCode());
    }
    @Test
    public void shouldSkipAuthorizationFilter() {
        HTTPSession session = HTTPSession.getInstance();
        session.setUserLogged(true);// simulamos que el usuario ya está autenticado
        HTTPRequest<User> request = new HTTPRequest<>();
        request.setBody(new User());
        request.setMethod(HTTPMethod.GET);
        request.setPath("/api/v1/user");
        HTTPResponse<User> response = this.http.submit(request);
        Assertions.assertEquals(HTTPStatus.OK, response.getStatusCode());
    }
}
