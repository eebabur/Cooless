package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetMatch {
    @SerializedName("location")
    public OffsetLocation location;


    public OffsetMatch(OffsetLocation location) {
        this.location = location;
    }
}