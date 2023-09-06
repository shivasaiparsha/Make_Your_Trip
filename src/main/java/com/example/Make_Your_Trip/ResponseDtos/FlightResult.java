package com.example.Make_Your_Trip.ResponseDtos;

import com.example.Make_Your_Trip.Models.Transport;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightResult {

    private LocalDate journeyDate;
    private LocalTime startTime;
    private double journeyTime;
    private String companyName;
    private String listOfStopInBetween;
}
