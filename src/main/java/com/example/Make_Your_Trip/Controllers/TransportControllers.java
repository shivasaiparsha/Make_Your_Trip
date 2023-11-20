package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDto.AddTransportDto;
import com.example.Make_Your_Trip.RequestDto.SearchFlightDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResult;
import com.example.Make_Your_Trip.Services.TransportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transport")
@Slf4j
public class TransportControllers {

    @Autowired
    private TransportService transportService;

    @PostMapping("/add")
    public ResponseEntity addTransport(@RequestBody AddTransportDto addTransportDto){
        try{
            String result = transportService.addTransport(addTransportDto);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            log.error("Add transport failed {}",e.getMessage());

            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping ("/searchFlights")
    public ResponseEntity searchFlights(@RequestBody SearchFlightDto searchFlightDto){

        List<FlightResult> flightResults = transportService.searchForFlights(searchFlightDto);

        return new ResponseEntity(flightResults,HttpStatus.OK);
    }

}
