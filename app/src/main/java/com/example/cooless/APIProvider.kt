package com.example.cooless

import com.example.cooless.API.CloverlyInterface
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object APIProvider {

    val offsetService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.cloverly.com/2019-03-beta/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CloverlyInterface::class.java)
    }
}