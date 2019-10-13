package com.example.cooless.POJOs.responseDuffel;

import com.google.gson.annotations.SerializedName;

public class Place {
    @SerializedName("iata_city_code")
    public String cityCode;
    @SerializedName("iata_code")
    public String iataCode;
    @SerializedName("iata_country_code")
    public String countryCode;
    @SerializedName("name")
    public String name;
}
