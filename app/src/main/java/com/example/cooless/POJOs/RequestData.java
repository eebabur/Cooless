package com.example.cooless.POJOs;

import java.util.List;

public class RequestData {

    private String cabin_class;
    private List<RequestSlice> slices = null;
    private List<RequestPassenger> passengers = null;

    /**
     * No args constructor for use in serialization
     */
    public RequestData() {
    }

    /**
     * @param cabinClass
     * @param passengers
     * @param slices
     */
    public RequestData(String cabinClass, List<RequestSlice> slices, List<RequestPassenger> passengers) {
        super();
        this.cabin_class = cabinClass;
        this.slices = slices;
        this.passengers = passengers;
    }

    public String getCabinClass() {
        return cabin_class;
    }

    public void setCabinClass(String cabinClass) {
        this.cabin_class = cabinClass;
    }

    public RequestData withCabinClass(String cabinClass) {
        this.cabin_class = cabinClass;
        return this;
    }

    public List<RequestSlice> getSlices() {
        return slices;
    }

    public void setSlices(List<RequestSlice> slices) {
        this.slices = slices;
    }

    public RequestData withSlices(List<RequestSlice> slices) {
        this.slices = slices;
        return this;
    }

    public List<RequestPassenger> getPassengers() {
        return this.passengers;
    }

    public void setPassengers(List<RequestPassenger> passengers) {
        this.passengers = passengers;
    }

    public RequestData withPassengers(List<RequestPassenger> passengers) {
        this.passengers = passengers;
        return this;
    }

}
