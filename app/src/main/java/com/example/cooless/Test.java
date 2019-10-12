package com.example.cooless;
import com.example.cooless.POJOs.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Test {
    static CloverlyInterface apiInterface;

    public static void main(String[] args) {
        apiInterface = APIClient.getClient().create(CloverlyInterface.class);
        User user = new User("morpheus", "leader");
        Call<User> call1 = apiInterface.createUser(user);
        call1.enqueue(new Callback<User>() {
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
