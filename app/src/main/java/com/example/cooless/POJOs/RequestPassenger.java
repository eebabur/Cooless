package com.example.cooless.POJOs;

public class RequestPassenger {

    private String type;

    /**
     * No args constructor for use in serialization
     *
     */
    public RequestPassenger() {
    }

    /**
     *
     * @param type
     */
    public RequestPassenger(String type) {
        super();
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RequestPassenger withType(String type) {
        this.type = type;
        return this;
    }

}
