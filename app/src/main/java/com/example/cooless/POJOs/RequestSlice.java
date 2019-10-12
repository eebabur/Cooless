package com.example.cooless.POJOs;

public class RequestSlice {

    private String departure_date;
    private String destination;
    private String origin;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestSlice() {
    }

    /**
     *
     * @param departureDate
     * @param origin
     * @param destination
     */
    public RequestSlice(String departureDate, String destination, String origin) {
        super();
        this.departure_date = departureDate;
        this.destination = destination;
        this.origin = origin;
    }

    public String getDepartureDate() {
        return departure_date;
    }

    public void setDepartureDate(String departureDate) {
        this.departure_date = departureDate;
    }

    public RequestSlice withDepartureDate(String departureDate) {
        this.departure_date = departureDate;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public RequestSlice withDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public RequestSlice withOrigin(String origin) {
        this.origin = origin;
        return this;
    }

}