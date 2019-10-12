package com.example.cooless.POJOs;

import com.google.gson.annotations.SerializedName;

public class OffestResponse {
    @SerializedName("slug")
    public String slug;
    @SerializedName("total_cost_in_usd_cents")
    public Integer totalCostCents;
    @SerializedName("pretty_url")
    public String url;
    @SerializedName("offset")
    public Offset offset;
}
