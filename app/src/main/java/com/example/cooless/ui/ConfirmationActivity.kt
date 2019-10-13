package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cooless.R
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class ConfirmationActivity : AppCompatActivity() {

    lateinit var flightPriceTextView: TextView
    lateinit var offsetPriceLabelTextView: TextView
    lateinit var offsetPriceTextView: TextView
    lateinit var totalPrice: TextView
    lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Details")
        setViews()

        intent.confirmationParams
            ?.run {
                flightPriceTextView.text = "£${flightPrice}"
                if(offsetPrice > 0) {
                    offsetPriceTextView.text = "£${offsetPrice}"
                } else {
                    offsetPriceTextView.visibility = View.GONE
                    offsetPriceLabelTextView.visibility = View.GONE
                }

                totalPrice.text = "£${flightPrice + offsetPrice}"


            }

        confirmButton.setOnClickListener {
            Toast.makeText(this, "Congrats!", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    fun setViews() {
        flightPriceTextView = findViewById(R.id.flightPrice)
        offsetPriceTextView = findViewById(R.id.offsetPrice)
        offsetPriceLabelTextView = findViewById(R.id.offsetPriceLabel)
        totalPrice = findViewById(R.id.totalPrice)
        confirmButton = findViewById(R.id.confirmButton)
    }

    companion object {
        var Intent.confirmationParams by IntentExtra.Serializable<ConfirmationParams>()

        fun createIntent(context: Context, confirmationParams: ConfirmationParams) =
            Intent(context, ConfirmationActivity::class.java).apply {
                this.confirmationParams = confirmationParams
            }
    }

    data class ConfirmationParams(
        val flightPrice: Int,
        val offsetPrice: Int
    ) : Serializable
}
