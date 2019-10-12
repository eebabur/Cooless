package com.example.cooless;
import com.example.cooless.API.APIClient;
import com.example.cooless.API.CloverlyInterface;
import com.example.cooless.POJOs.OffestResponse;
import com.example.cooless.POJOs.OffsetLocation;
import com.example.cooless.POJOs.OffsetMatch;
import com.example.cooless.POJOs.OffsetRequest;
import com.example.cooless.POJOs.OffsetWeight;
import com.example.cooless.POJOs.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
    static CloverlyInterface apiInterface;

    public static void main(String[] args) {
        apiInterface = APIClient
                .getClient("https://api.cloverly.com/2019-03-beta/")
                .create(CloverlyInterface.class);
        OffsetWeight offsetWeight = new OffsetWeight(95, "kg");
        OffsetLocation offsetLocation = new OffsetLocation("sfo");
        OffsetMatch offsetMatch = new OffsetMatch(offsetLocation);
        OffsetRequest offsetRequest = new OffsetRequest(offsetWeight, offsetMatch);
        Call<OffestResponse> call1 = apiInterface.getOffset(offsetRequest);
        call1.enqueue(new Callback<OffestResponse>() {
            @Override
            public void onResponse(Call<OffestResponse> call, Response<OffestResponse> response) {
                OffestResponse offestResponse = response.body();
                System.out.println(offestResponse);
            }

            @Override
            public void onFailure(Call<OffestResponse> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
