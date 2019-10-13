package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

public class Segment {
    @SerializedName("arriving_at")
    public String arrivingAt;
    @SerializedName("departing_at")
    public String departingAt;
    @SerializedName("duration")
    public String duration;
}
