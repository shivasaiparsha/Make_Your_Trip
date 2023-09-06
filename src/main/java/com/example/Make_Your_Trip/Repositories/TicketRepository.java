package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Models.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
