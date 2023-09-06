package com.example.Make_Your_Trip.Models;

import com.example.Make_Your_Trip.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.GenericArrayType;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Seat {

    @Id
    @GeneratedValue (strategy= GenerationType.IDENTITY)
    private Integer seatId;
     private String seatNo;

    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;

    private Integer price;

    @ManyToOne
    @JoinColumn
    private Transport transport;

}
