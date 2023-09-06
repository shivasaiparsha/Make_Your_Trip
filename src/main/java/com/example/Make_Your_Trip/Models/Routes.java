package com.example.Make_Your_Trip.Models;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Routes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Routes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeId;

   @Enumerated(value = EnumType.STRING)
    private City fromCity;
    @Enumerated(value = EnumType.STRING)
    private City toCity;
     private String listOfStopsInBetween;

    @Enumerated(value = EnumType.STRING)
    private ModeOfTransport modeOfTransport;

    @OneToMany(mappedBy = "routes", cascade = CascadeType.ALL)
    private List<Transport> transportList=new ArrayList<>();
}
