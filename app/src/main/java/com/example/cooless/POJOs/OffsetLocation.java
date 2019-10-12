package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetLocation {
    @SerializedName("airport_code")
    public String airportCode;

    public OffsetLocation(String airportCode) {
        this.airportCode = airportCode;
    }
}

