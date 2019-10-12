package com.example.cooless.API;

import com.example.cooless.POJOs.withData;
import com.example.cooless.POJOs.ReqObject;


import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DuffelInterface {

    @POST("offer_requests")
    @Headers({
            "Content-Type: application/json",
            "Duffel-Version: beta",
            "Accept: application/json",
            "Accept-Encoding: gzip",
            "Authorization: Bearer test_yGfnlHtnjj6_hDlo1uAgOyKRmsl3_9uiWU6PpdqzKlE"
    })
    Call<withData> getAllOffers(@Body ReqObject reqObject);
}
