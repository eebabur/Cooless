package com.example.cooless.POJOs;

import java.util.List;

public class ResponsePassenger {

    private List<Object> baggages = null;
    private String cabinClass;
    private String cabinClassMarketingName;
    private String passengerId;

    /**
     * No args constructor for use in serialization
     *
     */
    public ResponsePassenger() {
    }

    /**
     *
     * @param cabinClass
     * @param cabinClassMarketingName
     * @param passengerId
     * @param baggages
     */
    public ResponsePassenger(List<Object> baggages, String cabinClass, String cabinClassMarketingName, String passengerId) {
        super();
        this.baggages = baggages;
        this.cabinClass = cabinClass;
        this.cabinClassMarketingName = cabinClassMarketingName;
        this.passengerId = passengerId;
    }

    public List<Object> getBaggages() {
        return baggages;
    }

    public void setBaggages(List<Object> baggages) {
        this.baggages = baggages;
    }

    public ResponsePassenger withBaggages(List<Object> baggages) {
        this.baggages = baggages;
        return this;
    }

    public String getCabinClass() {
        return cabinClass;
    }

    public void setCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
    }

    public ResponsePassenger withCabinClass(String cabinClass) {
        this.cabinClass = cabinClass;
        return this;
    }

    public String getCabinClassMarketingName() {
        return cabinClassMarketingName;
    }

    public void setCabinClassMarketingName(String cabinClassMarketingName) {
        this.cabinClassMarketingName = cabinClassMarketingName;
    }

    public ResponsePassenger withCabinClassMarketingName(String cabinClassMarketingName) {
        this.cabinClassMarketingName = cabinClassMarketingName;
        return this;
    }

    public String getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(String passengerId) {
        this.passengerId = passengerId;
    }

    public ResponsePassenger withPassengerId(String passengerId) {
        this.passengerId = passengerId;
        return this;
    }

}