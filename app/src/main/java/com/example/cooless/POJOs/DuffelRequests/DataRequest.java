package com.example.cooless.POJOs.DuffelRequests;

import com.google.gson.annotations.SerializedName;

public class DataRequest {
    @SerializedName("data")
    public DataObject dataObject;

    public DataRequest(DataObject dataObject) {
        this.dataObject = dataObject;
    }
}

