package com.example.cooless.API;

import com.example.cooless.POJOs.responseDuffel.MainResponse;
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
            "Authorization: Bearer test_yGfnlHtnjj6_hDlo1uAgOyKRmsl3_9uiWU6PpdqzKlE",
            "Cache-Control: no-cache",
            "Postman-Token: a18c943d-7975-48fd-b578-512c8bbad9a9",
            "Host: api.duffel.com",
            "Content-Length: 259",
            "Connection: keep-alive",
    })
    Call<MainResponse> getAllOffers(@Body ReqObject reqObject);
}
