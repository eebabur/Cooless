package com.example.cooless.POJOs;

public class Origin {

    private String iataCityCode;
    private String iataCode;
    private String iataCountryCode;
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public Origin() {
    }

    /**
     *
     * @param iataCode
     * @param iataCityCode
     * @param name
     * @param iataCountryCode
     */
    public Origin(String iataCityCode, String iataCode, String iataCountryCode, String name) {
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

    public Origin withIataCityCode(String iataCityCode) {
        this.iataCityCode = iataCityCode;
        return this;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Origin withIataCode(String iataCode) {
        this.iataCode = iataCode;
        return this;
    }

    public String getIataCountryCode() {
        return iataCountryCode;
    }

    public void setIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
    }

    public Origin withIataCountryCode(String iataCountryCode) {
        this.iataCountryCode = iataCountryCode;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Origin withName(String name) {
        this.name = name;
        return this;
    }

}
