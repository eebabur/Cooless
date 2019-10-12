package com.example.cooless;

import com.example.cooless.API.APIClient;
import com.example.cooless.API.DuffelInterface;
import com.example.cooless.POJOs.MainData;
import com.example.cooless.POJOs.RequestData;
import com.example.cooless.POJOs.RequestSlice;
import com.example.cooless.POJOs.RequestPassenger;
import com.example.cooless.POJOs.ReqObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
    static DuffelInterface apiInterface;

    public static void main(String[] args) {


        RequestPassenger passenger = new RequestPassenger("adult");
        List<RequestPassenger> passengers = new ArrayList<RequestPassenger>();
        passengers.add(passenger);
        RequestSlice requestSlice = new RequestSlice("2020-02-09", "FRA", "LHR");
        List<RequestSlice> requestSlices = new ArrayList<RequestSlice>();
        requestSlices.add(requestSlice);
        RequestData requestData = new RequestData("economy", requestSlices, passengers);
        ReqObject reqObject = new ReqObject(requestData);
        apiInterface = APIClient.getClient("https://api.duffel.com/air/").create(DuffelInterface.class);
        Call call1 = apiInterface.getAllOffers(reqObject);
        call1.enqueue(new Callback<MainData>() {
            @Override
            public void onResponse(Call<MainData> call, Response<MainData> response) {
                System.out.println(response.body());
            }

            @Override
            public void onFailure(Call<MainData> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
