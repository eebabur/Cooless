package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {
    @SerializedName("offers")
    public List<Object> offers = null;
    @SerializedName("passengers")
    public List<Passenger> passengers = null;
    @SerializedName("slices")
    public List<Slice> slices = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponseData() {
    }

    /**
     *
     * @param passengers
     * @param slices
     * @param offers
     */
    public ResponseData(List<Object> offers, List<Passenger> passengers, List<Slice> slices) {
        super();
        this.offers = offers;
        this.passengers = passengers;
        this.slices = slices;
    }

    public List<Object> getOffers() {
        return offers;
    }

    public void setOffers(List<Object> offers) {
        this.offers = offers;
    }

    public ResponseData withOffers(List<Object> offers) {
        this.offers = offers;
        return this;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public ResponseData withPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }

    public List<Slice> getSlices() {
        return slices;
    }

    public void setSlices(List<Slice> slices) {
        this.slices = slices;
    }

    public ResponseData withSlices(List<Slice> slices) {
        this.slices = slices;
        return this;
    }

}
