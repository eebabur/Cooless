package com.example.cooless.POJOs;

import java.util.List;

public class Segment {

    private String arrivingAt;
    private String departingAt;
    private String marketingCarrierFlightNumber;
    private List<Passenger> passengers = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public Segment() {
    }

    /**
     *
     * @param departingAt
     * @param passengers
     * @param arrivingAt
     * @param marketingCarrierFlightNumber
     */
    public Segment(String arrivingAt, String departingAt, String marketingCarrierFlightNumber, List<Passenger> passengers) {
        super();
        this.arrivingAt = arrivingAt;
        this.departingAt = departingAt;
        this.marketingCarrierFlightNumber = marketingCarrierFlightNumber;
        this.passengers = passengers;
    }

    public String getArrivingAt() {
        return arrivingAt;
    }

    public void setArrivingAt(String arrivingAt) {
        this.arrivingAt = arrivingAt;
    }

    public Segment withArrivingAt(String arrivingAt) {
        this.arrivingAt = arrivingAt;
        return this;
    }

    public String getDepartingAt() {
        return departingAt;
    }

    public void setDepartingAt(String departingAt) {
        this.departingAt = departingAt;
    }

    public Segment withDepartingAt(String departingAt) {
        this.departingAt = departingAt;
        return this;
    }

    public String getMarketingCarrierFlightNumber() {
        return marketingCarrierFlightNumber;
    }

    public void setMarketingCarrierFlightNumber(String marketingCarrierFlightNumber) {
        this.marketingCarrierFlightNumber = marketingCarrierFlightNumber;
    }

    public Segment withMarketingCarrierFlightNumber(String marketingCarrierFlightNumber) {
        this.marketingCarrierFlightNumber = marketingCarrierFlightNumber;
        return this;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Segment withPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
        return this;
    }

}
