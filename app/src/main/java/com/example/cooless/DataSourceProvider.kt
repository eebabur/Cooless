package com.example.cooless

import com.example.cooless.API.CloverlyInterface
import com.example.cooless.API.DuffelInterface
import com.example.cooless.POJOs.*
import com.example.cooless.POJOs.DuffelRequests.DataObject
import com.example.cooless.POJOs.DuffelRequests.DataRequest
import com.example.cooless.POJOs.DuffelRequests.Passenger
import com.example.cooless.POJOs.DuffelRequests.Slice
import com.example.cooless.model.Flight
import com.example.cooless.model.OffsetOption
import com.example.cooless.model.OffsetReceipt
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.lang.StringBuilder

object DataSourceProvider {

    val offsetDataSource: OffsetDataSource by lazy { OffsetDataSourceImpl(APIProvider.offsetService) }
    val flightsDataSource: FlightDataSource by lazy { FlightDataSourceImpl(APIProvider.flightService) }
}

interface OffsetDataSource {

    fun getOffsetOptions(from: String, mass: Int): Single<List<OffsetOption>>
    fun makePayment(slug: String): Single<OffsetReceipt>
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

    override fun makePayment(slug: String): Single<OffsetReceipt>  =
        service.purchase(PaymentRequest(slug))
            .subscribeOn(Schedulers.io())
            .map { OffsetReceipt(it.offset.name, it.offset.category, it.prettyUrl) }
            .observeOn(AndroidSchedulers.mainThread())
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
            .map {

                val avg = it.data.offers.map { it.totalEmissionsKg.toDouble() }
                    .average()

                it.data.offers
                    .map {
                        Flight(
                            airlineName = it.owner.name,
                            date = date,
                            origin = from,
                            departure = formatTime(it.slices[0].segments[0].departingAt),
                            destination = to,
                            arrival = formatTime(it.slices[0].segments[0].arrivingAt),
                            duration = it.slices[0].segments[0].duration.substring(2),
                            price = it.totalAmount.toFloat().toInt(),
                            emission = it.totalEmissionsKg.toFloat().toInt(),
                            emissionAdvantage = if (it.totalEmissionsKg.toDouble() <= avg * 0.8f) ((it.totalEmissionsKg.toDouble() / avg) * 100).toInt() else null
                        )
                    }
                    .sortedByDescending { it.emissionAdvantage }
            }
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun formatTime(date: String): String {
        val sections = date.split("T")
        val times = sections[1].split(":")
        return times[0]+":"+times[1]
    }
}

