package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Enums.SeatType;
import com.example.Make_Your_Trip.Models.Seat;
import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.Repositories.SeatRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.RequestDto.AddFlightSeatDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatService {

    @Autowired

    private SeatRepository seatRepository;

    @Autowired
    private TransportRepository transportRepository;

    public String addFlightSeats(AddFlightSeatDto addFlightSeatDto)
    {
        Transport transport = transportRepository.findById(addFlightSeatDto.getTransportId()).get();

        for(int i=1; i<= addFlightSeatDto.getNoOfEconomySeats(); i++)
        {
            Seat seat=Seat.builder().seatNo("E"+i).seatType(SeatType.ECONOMY).price(addFlightSeatDto.getPriceOfEconomySeat())
                    .transport(transport)
                    .build();

            transport.getSeatList().add(seat);
        }

        for(int i=1; i<=addFlightSeatDto.getNoOfBusinessSeats(); i++)
        {
            Seat seat=Seat.builder().seatNo("B"+i).seatType(SeatType.BUSINESS).price(addFlightSeatDto.getPriceOfBusinessSeat())
                    .transport(transport).build();
            transport.getSeatList().add(seat);

        }

        transportRepository.save(transport);
        return "Defined seats have been added";
    }
}
