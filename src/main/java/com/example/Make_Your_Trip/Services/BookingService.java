package com.example.Make_Your_Trip.Services;

import com.example.Make_Your_Trip.Models.*;
import com.example.Make_Your_Trip.Repositories.BookingRepository;
import com.example.Make_Your_Trip.Repositories.TransportRepository;
import com.example.Make_Your_Trip.Repositories.UserRepository;
import com.example.Make_Your_Trip.RequestDto.BookingRequestDto;
import com.example.Make_Your_Trip.RequestDto.GetAvailableSeatsDto;
import com.example.Make_Your_Trip.ResponseDtos.AvailableSeatResponseDto;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static com.example.Make_Your_Trip.Transformers.BookingTransformers.convertRequestToEntity;

@Service

public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private TransportRepository transportRepository;

    @Autowired
    private UserRepository userRepository;

    public List<AvailableSeatResponseDto> getAvailableSeatsResponse(GetAvailableSeatsDto getAvailableSeatsDto)
    {
          List<Booking>  bookingsList = bookingRepository.findBOokingsByTransportIdAndJourneyDate(getAvailableSeatsDto.getTransportId(),getAvailableSeatsDto.getJourneyDate());

          Set<String> booked = new TreeSet<>();

          for(Booking book : bookingsList)
          {
              String seats=book.getSeatNos();
              String bookingsDone[]=seats.split(","); // string in the form 1A, 2A, 3A, 4A

              for(String seatNo : bookingsDone)
              {
                  booked.add(seatNo);
              }
          }

        Transport transport=transportRepository.findById(getAvailableSeatsDto.getTransportId()).get();

          List<Seat> seatList=transport.getSeatList();

          List<AvailableSeatResponseDto> availableseats=new ArrayList<>();

          for(Seat s : seatList)
          {
              if(booked.contains(s.getSeatNo()))
              {
                  continue ;
              }
              else
              {
                  AvailableSeatResponseDto avsrd=AvailableSeatResponseDto.builder().seatNo(s.getSeatNo()).seatPrice(s.getPrice())
                                                 .seatType(s.getSeatType()).build();
                  availableseats.add(avsrd);
              }


          }

          return availableseats;
    }
    public String makeBooking(BookingRequestDto bookingRequestDto)
    {
        User user=userRepository.findById(bookingRequestDto.getUserId()).get();

        Transport transport=transportRepository.findById(bookingRequestDto.getTransportId()).get();

        Booking booking=convertRequestToEntity(bookingRequestDto);

        TicketEntity ticketEntity=createTicket(transport, booking);

//         bookingRepository.save(booking);
         transport.getBookingsList().add(booking);
         transportRepository.save(transport);
         user.getBookingList().add(booking);
         userRepository.save(user);
         return "ticket booked successfully";
    }
    public TicketEntity createTicket(Transport transport, Booking booking)
    {
        Integer totalPricePaid=findtotalAmount(transport,booking.getSeatNos());
        String routeDetails=getRouteDetails(transport);

          TicketEntity ticketEntity=TicketEntity.builder().allSeatNos(booking.getSeatNos())
                                     .journeyDate(booking.getJourneyDate()).startTime(transport.getStartTime())
                                     .routeDetails(routeDetails).totalCostPaid(totalPricePaid).build();
          return ticketEntity;
    }

    public String getRouteDetails(Transport transport)
    {
         Routes routes=transport.getRoutes();
         String rout=routes.getFromCity()+" to "+routes.getToCity();
         return rout;
    }
    public Integer findtotalAmount(Transport transport, String seatNos)
    {
        List<Seat> seatList = transport.getSeatList();

        String seatArray[]=seatNos.split(",");
        Integer totalAmount=0;

        for(String s : seatArray)
        {
            for(Seat seat : seatList)
            {
                if(seat.getSeatNo().equals(s))
                {
                    totalAmount+=seat.getPrice();
                }
            }
        }

        return totalAmount;
    }
}
