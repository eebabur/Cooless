package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("slices")
    public List<Slice> slices;
    @SerializedName("offers")
    public List<Offer> offers;
    @SerializedName("passengers")
    public List<Passenger> passengers;
}
