package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.cooless.DataSourceProvider
import com.example.cooless.R
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class PaymentActivity : AppCompatActivity() {

    lateinit var flightPriceTextView: TextView
    lateinit var offsetPriceLabelTextView: TextView
    lateinit var offsetPriceTextView: TextView
    lateinit var totalPrice: TextView
    lateinit var confirmButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setTitle("Payment")
        setViews()

        intent.paymentParams
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

            DataSourceProvider.offsetDataSource.makePayment(intent.paymentParams!!.offsetSlug)
                .subscribe(
                    {
                        val params = ConfirmationActivity.ConfirmationParams(it.name, it.category, it.url)
                        val intent = ConfirmationActivity.createIntent(this, params)
                        startActivity(intent)
                    },
                    {}
                )

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setViews() {
        flightPriceTextView = findViewById(R.id.flightPrice)
        offsetPriceTextView = findViewById(R.id.offsetPrice)
        offsetPriceLabelTextView = findViewById(R.id.offsetPriceLabel)
        totalPrice = findViewById(R.id.totalPrice)
        confirmButton = findViewById(R.id.confirmButton)
    }

    companion object {
        var Intent.paymentParams by IntentExtra.Serializable<PaymentParams>()

        fun createIntent(context: Context, paymentParams: PaymentParams) =
            Intent(context, PaymentActivity::class.java).apply {
                this.paymentParams = paymentParams
            }
    }

    data class PaymentParams(
        val flightPrice: Int,
        val offsetPrice: Int,
        val offsetSlug: String
    ) : Serializable
}
