package com.example.Make_Your_Trip.ResponseDtos;


import com.example.Make_Your_Trip.Enums.SeatType;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvailableSeatResponseDto {

    private String seatNo;
    private SeatType seatType;
    private Integer seatPrice;
}
