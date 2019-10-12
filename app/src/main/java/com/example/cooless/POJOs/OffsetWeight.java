package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffsetWeight {
    @SerializedName("value")
    public Integer value;
    @SerializedName("units")
    public String units;

    public OffsetWeight(Integer value, String units) {
        this.value = value;
        this.units = units;
    }
}