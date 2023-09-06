package com.example.Make_Your_Trip.Exceptions;

public class RouteNotFoundException extends Exception {
    public RouteNotFoundException(String routeIsInvalid) {
        super(routeIsInvalid);
    }
}
