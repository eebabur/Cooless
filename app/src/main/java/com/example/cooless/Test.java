package com.example.cooless;
import com.example.cooless.API.APIClient;
import com.example.cooless.API.CloverlyInterface;
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
                .getClient("https://api.cloverly.com/2019-03-beta")
                .create(CloverlyInterface.class);
        OffsetWeight offsetWeight = new OffsetWeight(100, "kg");
        OffsetRequest offsetRequest = new OffsetRequest(offsetWeight);
        Call<OffsetRequest> call1 = apiInterface.listOffsets(offsetRequest);
        call1.enqueue(new Callback<>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User user1 = response.body();
                System.out.println(user1.name);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                call.cancel();
            }
        });
    }
}
