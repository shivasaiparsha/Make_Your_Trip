package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.RequestDto.AddRouteDto;
import com.example.Make_Your_Trip.Services.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route")
public class RouteController {

    @Autowired
    private RouteService routeService;

    @PostMapping("/add")
    public ResponseEntity<String> addRoute(@RequestBody AddRouteDto addRouteDto)
    {
         String message=routeService.addRoute(addRouteDto);
         return new ResponseEntity<>(message, HttpStatus.OK);
    }

}
