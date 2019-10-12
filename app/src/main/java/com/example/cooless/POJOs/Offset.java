package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class Offset {
    @SerializedName("name")
    public String OffsetName;
    @SerializedName("province")
    public String providence;
    @SerializedName("city")
    public String city;
    @SerializedName("country")
    public String country;
    @SerializedName("offset_type")
    public String offsetType;
}
