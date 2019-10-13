package com.example.cooless

import com.example.cooless.API.CloverlyInterface
import com.example.cooless.model.OffsetOption
import com.example.cooless.POJOs.DuffelRequests.DataRequest
import com.example.cooless.model.Flight
import com.example.cooless.API.DuffelInterface
import com.example.cooless.POJOs.*
import com.example.cooless.POJOs.DuffelRequests.DataObject
import com.example.cooless.POJOs.DuffelRequests.Passenger
import com.example.cooless.POJOs.DuffelRequests.Slice
import com.example.cooless.POJOs.responseDuffel.MainResponse
import com.example.cooless.POJOs.responseDuffel.Offer
import com.example.cooless.model.FlightsResponse
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

object DataSourceProvider {

    val offsetDataSource: OffsetDataSource by lazy { OffsetDataSourceImpl(APIProvider.offsetService) }
    val flightsDataSource: FlightDataSource by lazy { FlightDataSourceImpl(APIProvider.flightService) }
}

interface OffsetDataSource {

    fun getOffsetOptions(from: String, mass: Int): Single<List<OffsetOption>>
}

interface FlightDataSource {

    fun getAllFlights(from: String, to: String, date: String): Single<List<Flight>>
}

class OffsetDataSourceImpl(private val service: CloverlyInterface) : OffsetDataSource {
    override fun getOffsetOptions(from: String, mass: Int): Single<List<OffsetOption>> {
        val offsetRequest = OffsetRequest(
            OffsetWeight(mass, "kg"),
            OffsetMatch(OffsetLocation(from))
        )

        return service.getOffset(offsetRequest)
            .subscribeOn(Schedulers.io())
            .map {
                listOf(
                    OffsetOption(it.slug, it.offset.OffsetName, it.totalCostCents / 100f)
                )
            }
            .observeOn(AndroidSchedulers.mainThread())
    }
}

fun makeFlights(data: List<Offer>, date: String, from: String, to: String): List<Flight> {
    val flights = data.map {
            Flight(
                "",
                "",
                from,
                it.slices[0].segments[0].departingAt,
                to,
                it.slices[0].segments[0].arrivingAt,
                it.totalAmount,
                0
            )

    }
    return flights;

}

class FlightDataSourceImpl(private val service: DuffelInterface) : FlightDataSource {
    override fun getAllFlights(from: String, to: String, date: String): Single<List<Flight>> {
        val slices = ArrayList<Slice>();
        val passengers = ArrayList<Passenger>();
        val passenger = Passenger("adult");
        val slice = Slice(date, from, to);
        slices.add(slice);
        passengers.add(passenger);
        val flightsRequest = DataRequest(
            DataObject("economy", slices, passengers)
        )


        return service.getAllOffers(flightsRequest)
            .subscribeOn(Schedulers.io())
            .map { makeFlights(it.data.offers, date, from, to) }
            .observeOn(AndroidSchedulers.mainThread())

    }
}