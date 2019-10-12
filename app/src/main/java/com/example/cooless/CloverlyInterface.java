package com.example.cooless;

import com.example.cooless.POJOs.MultipleResource;
import com.example.cooless.POJOs.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface CloverlyInterface {

        @GET("/api/unknown")
        Call<MultipleResource> doGetListResources();

        @POST("/api/users")
        Call<User> createUser(@Body User user);
}
