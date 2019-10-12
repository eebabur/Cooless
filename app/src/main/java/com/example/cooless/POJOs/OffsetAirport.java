package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetAirport {
    @SerializedName("airport_code")
    public String airportCode;

    public OffsetAirport(String airportCode) {
        this.airportCode = airportCode;
    }
}

