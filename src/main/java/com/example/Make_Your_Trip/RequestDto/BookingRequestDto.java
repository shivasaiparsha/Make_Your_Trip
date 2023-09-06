package com.example.Make_Your_Trip.RequestDto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingRequestDto {

    private String seatNos; //Comma seperated Values : 1A,1C,1E

    private LocalDate journeyDate; // yyyy-mm-dd

    private Integer transportId;

    private Integer userId;
}
