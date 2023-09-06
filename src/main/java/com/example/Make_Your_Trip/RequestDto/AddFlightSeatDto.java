package com.example.Make_Your_Trip.RequestDto;

import lombok.Data;

@Data
public class AddFlightSeatDto {

    private int noOfEconomySeats;
    private int noOfBusinessSeats;
    private int priceOfBusinessSeat;
    private int priceOfEconomySeat;
    private int transportId;
}
