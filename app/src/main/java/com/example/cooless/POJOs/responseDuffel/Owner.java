package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

public class Owner {
    @SerializedName("iata_code")
    public String iataCode;
    @SerializedName("name")
    public String name;
}
