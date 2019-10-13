package com.example.cooless.POJOs.DuffelRequests;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

public class DataObject {
    @SerializedName("cabin_class")
    public String cabinClass;

    @SerializedName("slices")
    public ArrayList<Slice> slices;

    @SerializedName("passengers")
    public ArrayList<Passenger> passengers;

    public DataObject(String cabinClass, ArrayList<Slice> slices, ArrayList<Passenger> passengers) {
        this.cabinClass = cabinClass;
        this.slices = slices;
        this.passengers = passengers;
    }
}

