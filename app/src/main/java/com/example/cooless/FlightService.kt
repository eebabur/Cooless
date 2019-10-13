package com.example.cooless

import android.util.Log
import com.example.cooless.model.Flight
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.concurrent.TimeUnit
import kotlin.random.Random

interface FlightService {

    fun getFlights(from: String, to: String, date: String): Single<List<Flight>>
}

class FlightServiceMockImpl : FlightService {
    override fun getFlights(from: String, to: String, date: String): Single<List<Flight>> =
        Single.just(emptyList<Flight>())
            .delay(2000, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())

//    private val flights = List(100) {
//        Flight(
//            airlinePicture = "https://www.airporthaber.com/wk-uploads/news/thy2_1017.jpg",
//            airlineName = "Airline $it",
//            origin = "Origin $it",
//            da
//            departure = "10:25",
//            destination = "Destination $it",
//            arrival = "17:48",
//            price = "£${(Random.nextInt(100) * 10)}",
//            emissionAdvantage = if (it%5 == 0) it else null
//        )
//    }
}