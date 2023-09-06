package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.RequestDto.AddRouteDto;
import com.example.Make_Your_Trip.Transformers.RouteTransformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    @Autowired
    private RouteRepository routeRepository;

    public String addRoute(AddRouteDto addRouteDto)
    {
        Routes route = new Routes();

        Routes routeObj = RouteTransformers.convertRounteToEntity(addRouteDto);
        routeRepository.save(routeObj);
        return "Routes has been successfully added to DB. ";
    }
}
