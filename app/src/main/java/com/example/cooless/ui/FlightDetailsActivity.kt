package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.transition.TransitionManager
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.cooless.DataSourceProvider
import com.example.cooless.R
import com.example.cooless.model.OffsetOption
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
    lateinit var ticketPrice: TextView
    lateinit var offsetPrice: TextView
    lateinit var infoExpanded: ImageView
    lateinit var infoCollapsed: ImageView
    lateinit var offsetCta: View
    lateinit var offsetContainer: View
    lateinit var choiceContainer: View
    lateinit var optionsLoadingSpinner: ProgressBar
    lateinit var sourceSpinner: Spinner
    lateinit var amountLabel: TextView
    lateinit var amountSlider: SeekBar
    lateinit var cta: Button

    private var totalPrice: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flight_details)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Details")
        setViews()

        showOptionsLoading()

        intent.flightParams
            ?.run {
                totalPrice = price
                ticketPrice.text = "£${price}"
                cta.text = "Confirm £${totalPrice}"
                DataSourceProvider.offsetDataSource
                    .getOffsetOptions(origin, emission)
                    .subscribe(
                        { showOptions(it) },
                        {
                            Toast.makeText(
                                this@FlightDetailsActivity,
                                "Something went wrong, try again!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    )
            }


        offsetCta.setOnClickListener {
            TransitionManager.beginDelayedTransition(findViewById(android.R.id.content))
            offsetCta.visibility = View.GONE
            offsetContainer.visibility = View.VISIBLE
        }

        cta.setOnClickListener {
            val paymentParams = PaymentActivity.PaymentParams(
                intent.flightParams!!.price,
                totalPrice - intent.flightParams!!.price
            )
            val intent = PaymentActivity.createIntent(this, paymentParams)
            startActivity(intent)
        }

        infoExpanded.setOnClickListener { showInfoDialog() }
        infoCollapsed.setOnClickListener { showInfoDialog() }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun showInfoDialog() {
        AlertDialog.Builder(this)
            .setView(R.layout.info_modal)
            .create()
            .show()
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
        ticketPrice = findViewById(R.id.ticketPrice)
        offsetPrice = findViewById(R.id.offsetPrice)
        offsetCta = findViewById(R.id.offsetCta)
        infoCollapsed = findViewById(R.id.info_collapsed)
        infoExpanded = findViewById(R.id.info_expanded)
        offsetContainer = findViewById(R.id.offsetContainer)
        choiceContainer = findViewById(R.id.choiceContainer)
        optionsLoadingSpinner = findViewById(R.id.optionsLoadingSpinner)
        sourceSpinner = findViewById(R.id.sourceSpinner)
        amountLabel = findViewById(R.id.amountLabel)
        amountSlider = findViewById(R.id.amountSlider)
        cta = findViewById(R.id.cta)
    }

    fun showOptionsLoading() {
        choiceContainer.visibility = View.GONE
        optionsLoadingSpinner.visibility = View.VISIBLE
    }

    private fun showOptions(list: List<OffsetOption>) {
        val adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            list.map { it.source })
        sourceSpinner.adapter = adapter
        choiceContainer.visibility = View.VISIBLE
        optionsLoadingSpinner.visibility = View.GONE

        offsetPrice.text = "£0"
        amountSlider.min = 0
        amountSlider.max = 100
        totalPrice = intent.flightParams!!.price + amountSlider.progress * list.first().cost.toInt()

        amountSlider.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                override fun onStartTrackingTouch(seekBar: SeekBar?) {}

                override fun onStopTrackingTouch(seekBar: SeekBar?) {}

                override fun onProgressChanged(
                    seekBar: SeekBar?,
                    progress: Int,
                    fromUser: Boolean
                ) {
                    amountLabel.text = "I want to offset ${progress}% of my emissions."
                    totalPrice =
                        (intent.flightParams!!.price + progress * list.first().cost).toInt()
                    offsetPrice.text = "£${(progress * list.first().cost).toInt()}"
                    if (progress == 0) cta.text = "Confirm £${totalPrice}" else cta.text =
                        "Offset and Go £${totalPrice}"
                }
            }
        )
    }

    companion object {
        var Intent.flightParams by IntentExtra.Serializable<FlightParams>()

        fun createIntent(context: Context, flightParams: FlightParams) =
            Intent(context, FlightDetailsActivity::class.java).apply {
                this.flightParams = flightParams
            }
    }

    data class FlightParams(
        val airlinePicture: String = "https://www.airporthaber.com/wk-uploads/news/thy2_1017.jpg",
        val airlineName: String = "Turkish Airlines",
        val day: Int = 9,
        val month: Int = 2,
        val year: Int = 2020,
        val origin: String = "FRA",
        val departure: String = "14:20",
        val destination: String = "LHR",
        val arrival: String = "22:05",
        val duration: String = "1h 25m",
        val price: Int = 232,
        val emission: Int = 50
    ) : Serializable
}
