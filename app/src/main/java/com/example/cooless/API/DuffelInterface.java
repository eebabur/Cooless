package com.example.cooless.API;

import com.example.cooless.POJOs.DuffelRequests.DataRequest;
import com.example.cooless.POJOs.responseDuffel.MainResponse;
import com.example.cooless.POJOs.ReqObject;


import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DuffelInterface {

    @POST("air/offer_requests")
    @Headers({
            "Content-Type: application/json",
            "Duffel-Version: beta",
            "Accept: application/json",
            "Authorization: Bearer test_yGfnlHtnjj6_hDlo1uAgOyKRmsl3_9uiWU6PpdqzKlE"
    })
    Single<MainResponse> getAllOffers(@Body DataRequest reqObject);
}
