package com.example.cooless.API

import com.google.gson.annotations.SerializedName
import io.reactivex.Single
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface DuffelService {

    @Headers(
        "Authorization: Bearer test_yGfnlHtnjj6_hDlo1uAgOyKRmsl3_9uiWU6PpdqzKlE",
        "Content-Type: application/json",
        "Duffel-Version: beta",
        "Accept: application/json"//,
        //"Accept-Encoding: gzip"
    )
    @POST("air/offer_requests")
    fun getFlights(@Body data: FlightsNetworkEntity): Single<FlightsNetworkEntity.ResponseDataObject>
}

data class FlightsNetworkEntity(
    @SerializedName("data") val data: RequestDataObject
) {
    data class RequestDataObject(
        @SerializedName("cabin_class") val cabinClass: String,
        @SerializedName("slices") val slices: List<Slice>,
        @SerializedName("passengers") val passengers: List<Passenger>
    ) {
        data class Slice(
            @SerializedName("departure_date") val departure: String,
            @SerializedName("destination") val destination: String,
            @SerializedName("origin") val origin: String
        )

        data class Passenger(
            @SerializedName("type") val type: String
        )
    }

    data class ResponseDataObject(
        @SerializedName("data") val data: Map<String, Object>
    )
}