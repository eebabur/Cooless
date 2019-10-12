package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.SeekBar
import android.widget.Spinner
import android.widget.TextView
import com.example.cooless.R
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class FlightDetailsActivity : AppCompatActivity() {

    lateinit var airlinePicture: ImageView
    lateinit var airlineName: TextView
    lateinit var date: TextView
    lateinit var departure: TextView
    lateinit var origin: TextView
    lateinit var destination: TextView
    lateinit var arrival: TextView
    lateinit var duration: TextView
    lateinit var price: TextView
    lateinit var offsetCta: View
    lateinit var offsetContainer: View
    lateinit var sourceSpinner: Spinner
    lateinit var amountLabel: TextView
    lateinit var amountSlider: SeekBar
    lateinit var cta: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Details")
        setViews()
    }

    private fun setViews() {
        airlinePicture = findViewById(R.id.airlinePicture)
        airlineName = findViewById(R.id.airlineName)
        date = findViewById(R.id.date)
        departure = findViewById(R.id.departure)
        origin = findViewById(R.id.origin)
        destination = findViewById(R.id.destination)
        arrival = findViewById(R.id.arrival)
        duration = findViewById(R.id.duration)
        price = findViewById(R.id.price)
        offsetCta = findViewById(R.id.offsetCta)
        offsetContainer = findViewById(R.id.offsetContainer)
        offsetContainer = findViewById(R.id.offsetContainer)
        sourceSpinner = findViewById(R.id.sourceSpinner)
        amountLabel = findViewById(R.id.amountLabel)
        amountSlider = findViewById(R.id.amountSlider)
        cta = findViewById(R.id.cta)
    }

    companion object {
        var Intent.flightParams by IntentExtra.Serializable<FlightParams>()

        fun createIntent(context: Context, flightParams: FlightParams) =
            Intent(context, FlightDetailsActivity::class.java).apply {
                this.flags = flags
            }
    }

    data class FlightParams(
        val airlinePicture: String = "https://www.airporthaber.com/wk-uploads/news/thy2_1017.jpg",
        val airlineName: String = "Turkish Airlines",
        val day: String = "13",
        val month: String = "10",
        val year: String = "2019",
        val origin: String = "FRA",
        val departure: String = "14:20",
        val destination: String = "LHR",
        val arrival: String = "22:05",
        val duration: String = "1h 25m",
        val price: String = "£232",
        val offsetSources: List<String> = emptyList()
    ) : Serializable
}
