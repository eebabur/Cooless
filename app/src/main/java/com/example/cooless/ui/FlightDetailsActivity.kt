package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cooless.R
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class FlightDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Details")
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
        val price: String = "£232"
    ) : Serializable
}
