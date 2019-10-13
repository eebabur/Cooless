package com.example.cooless.POJOs.DuffelRequests;

import com.google.gson.annotations.SerializedName;

public class Slice {
    @SerializedName("departure_date")
    public String departureDate;

    @SerializedName("destination")
    public String destination;

    @SerializedName("origin")
    public String origin;


    public Slice(String departureDate, String destination, String origin) {
        this.departureDate = departureDate;
        this.destination = destination;
        this.origin = origin;
    }
}
