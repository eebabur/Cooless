package com.example.cooless.POJOs.DuffelRequests;

import com.google.gson.annotations.SerializedName;

public class Passenger {
    @SerializedName("type")
    public String type;

    public Passenger(String type) {
        this.type = type;
    }
}
