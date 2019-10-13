package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

public class Slice {
    @SerializedName("departure_date")
    public String departureDate;

    @SerializedName("destination")
    public Place destination;

    @SerializedName("origin")
    public Place origin;

}
