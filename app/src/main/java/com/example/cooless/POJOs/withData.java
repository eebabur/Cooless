package com.example.cooless.POJOs;


import com.google.gson.annotations.SerializedName;

public class withData {

    @SerializedName("data")
    public ResponseData data;

    /**
     * No args constructor for use in serialization
     *
     */
    public withData() {
    }

    /**
     *
     * @param data
     */
    public withData(ResponseData data) {
        super();
        System.out.println(data);
        this.data = data;
    }

    public ResponseData getData() {
        return data;
    }

}
