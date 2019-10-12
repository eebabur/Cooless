package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetLocation {
    @SerializedName("airport")
    public String airport;

    public OffsetLocation(String airport) {
        this.airport = airport;
    }
}
