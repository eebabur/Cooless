package com.example.cooless.API;

import com.example.cooless.POJOs.MultipleResource;
import com.example.cooless.POJOs.OffsetRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CloverlyInterface {

        @POST("/purchases/carbon")
        @Headers({
                "Accept: application/json",
                "Bearer public_key:e33eaf017307254f"
        })
        Call<OffsetRequest> listOffsets(@Body OffsetRequest offsetRequest);
}
