package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Offer {
    @SerializedName("owner")
    public Owner owner;
    @SerializedName("slices")
    public List<OfferSlice> slices;
    @SerializedName("total_amount")
    public String totalAmount;
    @SerializedName("total_emissions_kg")
    public String totalEmissionsKg;

}
