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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Confirmation"
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }



    companion object {
        var Intent.params by IntentExtra.Serializable<ConfirmationParams>()

        fun createIntent(context: Context, params: ConfirmationParams) =
            Intent(context, ConfirmationActivity::class.java).apply {
                this.params = params
            }
    }

    data class ConfirmationParams(
        val name: String,
        val category: String,
        val url: String
    ) : Serializable
}
