package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.cooless.*
import com.example.cooless.model.Flight
import com.example.cooless.ui.FlightDetailsActivity.FlightParams
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_flights.retryButton
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class FlightsActivity : AppCompatActivity() {

    val disposable = CompositeDisposable()
    val flightService: FlightDataSource = DataSourceProvider.flightsDataSource
    lateinit var list: RecyclerView
    lateinit var loadingSpinner: ProgressBar
    lateinit var adapter: FlightAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flights)
        setViews()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("${intent.searchParams?.from} - ${intent.searchParams?.to} / ${intent.searchParams?.date}".toUpperCase())

        list.layoutManager = LinearLayoutManager(this)
        adapter = FlightAdapter { showFlightDetails(it) }
        list.adapter = adapter

        retryButton.setOnClickListener {
            loadData()
        }

        loadData()
    }

    override fun onDestroy() {
        disposable.clear()
        super.onDestroy()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showFlightDetails(flight: Flight) {
        val params = FlightParams(
            airlineName = flight.airlineName,
            origin = flight.origin,
            departure = flight.departure,
            destination = flight.destination,
            arrival = flight.destination,
            duration = flight.duration,
            price = flight.price,
            emission = flight.emission
        )
        val intent = FlightDetailsActivity.createIntent(this, params)
        startActivity(intent)
    }

    private fun loadData() {
        intent.searchParams
            ?.let {
                disposable.add(
                    flightService.getAllFlights(it.from, it.to, it.date)
                        .doOnSubscribe { showLoading() }
                        .subscribe(
                            { showFlights(it) },
                            { showError() }
                        )
                )
            }
    }

    private fun showFlights(flights: List<Flight>) {
        adapter.updateModel(flights)
        list.visibility = View.VISIBLE
        loadingSpinner.visibility = View.GONE
        retryButton.visibility = View.GONE
    }

    private fun showLoading() {
        list.visibility = View.GONE
        loadingSpinner.visibility = View.VISIBLE
        retryButton.visibility = View.GONE
    }

    private fun showError() {
        disposable.clear()
        list.visibility = View.GONE
        loadingSpinner.visibility = View.GONE
        retryButton.visibility = View.VISIBLE
        Toast.makeText(this, "Something went wrong, please try again!", Toast.LENGTH_SHORT).show()
    }

    private fun setViews() {
        list = findViewById(R.id.list)
        loadingSpinner = findViewById(R.id.loadingSpinner)
    }

    companion object {
        var Intent.searchParams by IntentExtra.Serializable<SearchParams>()

        fun createIntent(context: Context, searchParams: SearchParams) =
            Intent(context, FlightsActivity::class.java).apply {
                this.searchParams = searchParams
            }
    }

    data class SearchParams(
        val from: String,
        val to: String,
        val date: String
    ) : Serializable
}
