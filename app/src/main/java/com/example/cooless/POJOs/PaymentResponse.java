package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class PaymentResponse {
    @SerializedName("pretty_url")
    public String prettyUrl;
    @SerializedName("offset")
    public OffsetInnerData offset;
}
