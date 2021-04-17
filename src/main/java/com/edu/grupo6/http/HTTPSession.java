package com.edu.grupo6.http;

public class HTTPSession {

    private static HTTPSession instance = null;
    private static Boolean userLogged = false;

    HTTPSession() {
        userLogged = false;
    }
    public static HTTPSession getInstance() {
        if (instance == null) {
            return new HTTPSession();
        }
        return instance;
    }

    public synchronized Boolean isUserAuthenticated() {
        return userLogged;
    }

    public synchronized void setUserLogged(Boolean userLoged) {
        userLogged = userLoged;
    }

}
