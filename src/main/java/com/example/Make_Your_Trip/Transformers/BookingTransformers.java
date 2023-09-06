package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Booking;
import com.example.Make_Your_Trip.RequestDto.BookingRequestDto;
import lombok.Builder;

import java.awt.print.Book;
@Builder
public class BookingTransformers {

    public static Booking convertRequestToEntity(BookingRequestDto bookingRequestDto)
    {
        Booking newBooking=Booking.builder().journeyDate(bookingRequestDto.getJourneyDate())
                            .seatNos(bookingRequestDto.getSeatNos()).transportId(bookingRequestDto.getTransportId()).build();
        return newBooking;

    }
}
