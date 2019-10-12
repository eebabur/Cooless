package com.example.cooless.API;

import com.example.cooless.POJOs.OffestResponse;
import com.example.cooless.POJOs.OffsetRequest;
import com.example.cooless.POJOs.PaymentRequest;
import com.example.cooless.POJOs.PaymentResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CloverlyInterface {

        @POST("estimates/carbon")
        @Headers({
                "Accept: application/json",
                "Authorization: Bearer public_key:e33eaf017307254f"
        })
        Call<OffestResponse> getOffset(@Body OffsetRequest offsetRequest);

        @POST("purchases")
        @Headers({
                "Accept: application/json",
                "Authorization: Bearer public_key:e33eaf017307254f"
        })
        Call<PaymentResponse> purchase(@Body PaymentRequest paymentRequest);
}
