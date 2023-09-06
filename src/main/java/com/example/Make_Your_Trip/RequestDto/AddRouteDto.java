package com.example.Make_Your_Trip.RequestDto;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import lombok.Data;

@Data
public class AddRouteDto {

    private City fromCity;
    private City  toCity;
    private String stopsInBetween;
    private ModeOfTransport modeOfTransport;

}
