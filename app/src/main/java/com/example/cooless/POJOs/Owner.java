package com.example.cooless.POJOs;

public class Owner {

    private String iataCode;
    private String id;
    private String name;

    /**
     * No args constructor for use in serialization
     *
     */
    public Owner() {
    }

    /**
     *
     * @param id
     * @param iataCode
     * @param name
     */
    public Owner(String iataCode, String id, String name) {
        super();
        this.iataCode = iataCode;
        this.id = id;
        this.name = name;
    }

    public String getIataCode() {
        return iataCode;
    }

    public void setIataCode(String iataCode) {
        this.iataCode = iataCode;
    }

    public Owner withIataCode(String iataCode) {
        this.iataCode = iataCode;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Owner withId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner withName(String name) {
        this.name = name;
        return this;
    }

}
