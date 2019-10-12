package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetLocation {
    @SerializedName("location")
    public OffsetAirport location;

    public OffsetLocation(OffsetAirport location) {
        this.location = location;
    }
}
