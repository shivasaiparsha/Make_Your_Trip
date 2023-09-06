package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.Repositories.SeatRepository;
import com.example.Make_Your_Trip.RequestDto.AddFlightSeatDto;
import com.example.Make_Your_Trip.Services.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @PostMapping("/addFlightSeats")
    public ResponseEntity<String> addFlightSeats(@RequestBody AddFlightSeatDto addFlightSeatDto)
    {
        String message = seatService.addFlightSeats(addFlightSeatDto);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}
