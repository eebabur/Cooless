package com.example.cooless.POJOs;

public class Destination {

    private String iataCityCode;
    private String iataCode;
    private String iataCountryCode;
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public Destination() {
    }

    /**
     *
     * @param iataCode
     * @param iataCityCode
     * @param name
     * @param iataCountryCode
     */
    public Destination(String iataCityCode, String iataCode, String iataCountryCode, String name) {
        super();
        this.iataCityCode = iataCityCode;
        this.iataCode = iataCode;
        this.iataCountryCode = iataCountryCode;
        this.name = name;
    }

    public String getIataCityCode() {
        return iataCityCode;
    }

    public void setIataCityCode(String iataCityCode) {
        this.iataCityCode = iataCityCode;
    }

    public Destination withIataCityCode(String iataCityCode) {
        this.iataCityCode = iataCityCode;
        return this;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Destination withIataCode(String iataCode) {
        this.iataCode = iataCode;
        return this;
    }

    public String getIataCountryCode() {
        return iataCountryCode;
    }

    public void setIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
    }

    public Destination withIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Destination withName(String name) {
        this.name = name;
        return this;
    }

}
