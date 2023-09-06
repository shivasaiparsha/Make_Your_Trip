package com.example.Make_Your_Trip.Transformers;

import com.example.Make_Your_Trip.Models.Transport;
import com.example.Make_Your_Trip.RequestDto.AddTransportDto;
import com.example.Make_Your_Trip.ResponseDtos.FlightResult;
import lombok.Builder;

@Builder
public class TransportTransformer {

    public static Transport convertTransportDto(AddTransportDto addTransportDto)
    {
        Transport transport=Transport.builder().modeOfTransport(addTransportDto.getModeOfTransport())
                             .companyName(addTransportDto.getCompanyName()).journeyTime(addTransportDto.getJourneyTime())
                              .journeyDate(addTransportDto.getJourneyDate()).startTime(addTransportDto.getStartTime()).build();
        return transport;
    }
    public static FlightResult convertEntityToFlightResult(Transport transport){

        return FlightResult.builder().journeyDate(transport.getJourneyDate()).journeyTime(transport.getJourneyTime())
                .startTime(transport.getStartTime()).companyName(transport.getCompanyName()).build();

    }
}
