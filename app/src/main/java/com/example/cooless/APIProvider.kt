package com.example.cooless

import android.util.Log
import com.example.cooless.API.CloverlyInterface
import com.example.cooless.API.DuffelService
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
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

    val flightService by lazy {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)

            .build()
        Retrofit.Builder()
            .baseUrl("https://api.duffel.com/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(DuffelService::class.java)
    }
}