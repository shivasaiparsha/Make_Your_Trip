package com.example.Make_Your_Trip.Models;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "ticket")
@Builder
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ticketId;

    private String routeDetails;

    private LocalDate journeyDate;

    private LocalTime startTime;

    private Integer totalCostPaid;

    private String allSeatNos;

    @OneToOne
    @JoinColumn
    private Booking bookings;


}
