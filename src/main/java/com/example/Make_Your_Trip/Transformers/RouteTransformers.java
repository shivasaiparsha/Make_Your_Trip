package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.RequestDto.AddRouteDto;

public class RouteTransformers {

    public static Routes convertRounteToEntity(AddRouteDto addRouteDto)
    {
        Routes routeObject = Routes.builder().
                fromCity(addRouteDto.getFromCity())
                .toCity(addRouteDto.getToCity())
                .listOfStopsInBetween(addRouteDto.getStopsInBetween())
                .modeOfTransport(addRouteDto.getModeOfTransport())
                .build();
        return routeObject;
    }
}
