package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Exceptions.RouteNotFoundException;
import com.example.Make_Your_Trip.Models.Routes;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.RouteRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDto.AddTransportDto;
import com.example.Make_Your_Trip.RequestDto.SearchFlightDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResult;
import com.example.Make_Your_Trip.Transformers.TransportTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransportService {

    @Autowired
   private TransportRepository transportRepository;

    @Autowired
    private RouteRepository routeRepository;

    public String addTransport(AddTransportDto addTransportDto) throws Exception
    {
        Transport transport= TransportTransformer.convertTransportDto(addTransportDto);

        Optional<Routes> routes = routeRepository.findById(addTransportDto.getRouteId());

            if(!routes.isPresent())
               throw new RouteNotFoundException("Route is Invalid");
            Routes ro=routes.get();
        transport.setRoute(ro);

        ro.getTransportList().add(transport);
        routeRepository.save(ro);
        return "transport added successfully";
    }
    public List<FlightResult> searchForFlights(SearchFlightDto searchFlightDto)
    {
        List<Routes> routesList=routeRepository.findRoutesByFromCityAndToCityAndModeOfTransport(searchFlightDto.getFromCity(),searchFlightDto.getToCity(),ModeOfTransport.Flight);

        List<FlightResult> flightResults=new ArrayList<>();

        for(Routes route : routesList)
        {
            List<Transport> transportList=route.getTransportList();
            for(Transport transport : transportList)
            {
                 if(transport.getJourneyDate().equals(searchFlightDto.getJourneyDate()))
                 {
                     FlightResult flightResult=TransportTransformer.convertEntityToFlightResult(transport);

                     flightResult.setListOfStopInBetween(flightResult.getListOfStopInBetween());
                     flightResults.add(flightResult);
                 }
            }
        }
        return flightResults;
    }
}
