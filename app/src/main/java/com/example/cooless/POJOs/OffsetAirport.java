package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetAirport {
    @SerializedName("airport")
    public String airport;

    public OffsetAirport(String airport) {
        this.airport = airport;
    }
}
