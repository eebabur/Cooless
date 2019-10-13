package com.example.cooless.POJOs;

public class ReqObject {

    private RequestData data;

    /**
     * No args constructor for use in serialization
     */
    public ReqObject() {
    }

    /**
     * @param requestData
     */
    public ReqObject(RequestData requestData) {
        super();
        this.data = requestData;
    }

    public RequestData getRequestData() {
        return data;
    }

    public void setRequestData(RequestData requestData) {
        this.data = requestData;
    }

    public ReqObject withData(RequestData requestData) {
        this.data = requestData;
        return this;
    }

}
