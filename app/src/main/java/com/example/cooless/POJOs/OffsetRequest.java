package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetRequest {
    @SerializedName("weight")
    public OffsetWeight weight;
    @SerializedName("offset_match")
    public OffsetMatch offsetMatch;

    public OffsetRequest(OffsetWeight weight, OffsetMatch offsetMatch) {
        this.weight = weight;
        this.offsetMatch = offsetMatch;
    }
}
