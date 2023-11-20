package com.example.Make_Your_Trip.Controllers;

import com.example.Make_Your_Trip.RequestDto.BookingRequestDto;
import com.example.Make_Your_Trip.RequestDto.GetAvailableSeatsDto;
import com.example.Make_Your_Trip.ResponseDtos.AvailableSeatResponseDto;
import com.example.Make_Your_Trip.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingControllers {

    @Autowired
    private BookingService bookingService;

    @GetMapping ("/getAvailableSeats")
    public    ResponseEntity getAvailableSeats(@RequestBody GetAvailableSeatsDto getAvailableSeatsDto)
    {
        List<AvailableSeatResponseDto> availableseats=bookingService.getAvailableSeatsResponse(getAvailableSeatsDto);
        return new ResponseEntity(availableseats, HttpStatus.OK);
    }

   @PostMapping("/bookFlight")
    public ResponseEntity bookFlight(@RequestBody BookingRequestDto bookingRequestdto)
    {
          String meesage=bookingService.makeBooking(bookingRequestdto);
          return new ResponseEntity<>(meesage, HttpStatus.OK);
    }

}
