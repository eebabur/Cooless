package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class PaymentRequest {
    @SerializedName("estimate_slug")
    public String estimateSlug;

    public PaymentRequest(String estimateSlug) {
        this.estimateSlug = estimateSlug;
    }
}
