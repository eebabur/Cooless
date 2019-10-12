package com.example.cooless.API;

import com.example.cooless.POJOs.OffsetResponse;
import com.example.cooless.POJOs.OffsetRequest;
import com.example.cooless.POJOs.PaymentRequest;
import com.example.cooless.POJOs.PaymentResponse;

import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface CloverlyInterface {

        @POST("estimates/carbon")
        @Headers({
                "Accept: application/json",
                "Authorization: Bearer public_key:e33eaf017307254f"
        })
        Single<OffsetResponse> getOffset(@Body OffsetRequest offsetRequest);

        @POST("purchases")
        @Headers({
                "Accept: application/json",
                "Authorization: Bearer public_key:e33eaf017307254f"
        })
        Single<PaymentResponse> purchase(@Body PaymentRequest paymentRequest);
}
