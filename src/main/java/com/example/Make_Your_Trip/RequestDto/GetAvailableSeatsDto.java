package com.example.Make_Your_Trip.RequestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAvailableSeatsDto {
    private LocalDate journeyDate;
    private int transportId;

}
