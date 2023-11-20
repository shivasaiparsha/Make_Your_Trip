package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "select * from booking where transportId= :transportIdInput and journeyDate=:journeyDateInput",nativeQuery = true)
    List<Booking> findBookingsByTransportIdAndJourneyDate(Integer transportIdInput, LocalDate journeyDateInput);

}
