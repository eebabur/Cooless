package com.example.cooless;
<<<<<<< Updated upstream
import com.example.cooless.API.APIClient;
import com.example.cooless.API.CloverlyInterface;
import com.example.cooless.POJOs.OffsetResponse;
import com.example.cooless.POJOs.OffsetLocation;
import com.example.cooless.POJOs.OffsetMatch;
import com.example.cooless.POJOs.OffsetRequest;
import com.example.cooless.POJOs.OffsetWeight;
=======

import com.example.cooless.POJOs.withData;
import com.example.cooless.POJOs.RequestData;
import com.example.cooless.POJOs.RequestSlice;
import com.example.cooless.POJOs.RequestPassenger;
import com.example.cooless.POJOs.ReqObject;

import java.util.ArrayList;
import java.util.List;
>>>>>>> Stashed changes

import io.reactivex.Single;

public class Test {
    static DuffelInterface apiInterface;

    public static void main(String[] args) {
<<<<<<< Updated upstream
        apiInterface = APIClient
                .getClient("https://api.cloverly.com/2019-03-beta/")
                .create(CloverlyInterface.class);
        OffsetWeight offsetWeight = new OffsetWeight(95, "kg");
        OffsetLocation offsetLocation = new OffsetLocation("lhr");
        OffsetMatch offsetMatch = new OffsetMatch(offsetLocation);
        OffsetRequest offsetRequest = new OffsetRequest(offsetWeight, offsetMatch);


        Single<OffsetResponse> call1 = apiInterface.getOffset(offsetRequest);


//        call1.enqueue(new Callback<OffsetResponse>() {
//            @Override
//            public void onResponse(Call<OffsetResponse> call, Response<OffsetResponse> response) {
//                OffsetResponse offestResponse = response.body();
//                System.out.println(offestResponse.totalCostCents);
//            }
//
//            @Override
//            public void onFailure(Call<OffsetResponse> call, Throwable t) {
//                call.cancel();
//            }
//        });
//        PaymentRequest purchase = new PaymentRequest("20191012-9077b0c2e6f077e43e47c432e7607f30");
//        Single<PaymentResponse> call2 = apiInterface.purchase(purchase);
//        call2.enqueue(new Callback<PaymentResponse>() {
//            @Override
//            public void onResponse(Call<PaymentResponse> call, Response<PaymentResponse> response) {
//                PaymentResponse paymentResponse = response.body();
//                System.out.println(paymentResponse.prettyUrl);
//            }
//
//            @Override
//            public void onFailure(Call<PaymentResponse> call, Throwable t) {
//                call.cancel();
//            }
//        });
=======

        RequestPassenger passenger = new RequestPassenger("adult");
        List<RequestPassenger> passengers = new ArrayList<RequestPassenger>();
        passengers.add(passenger);
        RequestSlice requestSlice = new RequestSlice("2020-02-09", "FRA", "LHR");
        List<RequestSlice> requestSlices = new ArrayList<RequestSlice>();
        requestSlices.add(requestSlice);
        RequestData requestData = new RequestData("economy", requestSlices, passengers);
        ReqObject reqObject = new ReqObject(requestData);
        apiInterface = APIClient.getClient().create(DuffelInterface.class);
        Call call1 = apiInterface.getAllOffers(reqObject);
        call1.enqueue(new Callback<withData>() {
            @Override
            public void onResponse(Call<withData> call, Response<withData> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<withData> call, Throwable t) {
                call.cancel();
            }
        });
>>>>>>> Stashed changes
    }
}
