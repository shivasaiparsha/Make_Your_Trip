package com.example.Make_Your_Trip.Repositories;

import com.example.Make_Your_Trip.Enums.City;
import com.example.Make_Your_Trip.Enums.ModeOfTransport;
import com.example.Make_Your_Trip.Models.Routes;
import lombok.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface RouteRepository extends JpaRepository<Routes, Integer> {

//    @Query(value = "select * from routes where  fromCity= :fromCityinput and toCity = :toCityinput and modeOfTransport = :Flight",nativeQuery = true)

    List<Routes> findRoutesByFromCityAndToCityAndModeOfTransport(City fromCityinput, City toCityinput, ModeOfTransport modeOfTransport);
}
