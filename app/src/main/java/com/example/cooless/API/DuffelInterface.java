package com.example.cooless.API;

import com.example.cooless.POJOs.DuffelRequests.DataRequest;
import com.example.cooless.POJOs.DuffelRequests.DuffelResponse;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface DuffelInterface {
    @POST("air/offer_requests")
    @Headers({
            "Accept: application/json",
            "Authorization: Bearer test_yGfnlHtnjj6_hDlo1uAgOyKRmsl3_9uiWU6PpdqzKlE",
            "Content-Type: application/json",
            "Duffel-Version: beta",
            "Accept-Encoding: identity"
    })
    Single<DuffelResponse> getFlights(@Body DataRequest dataRequest);
}
