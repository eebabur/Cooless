package com.example.cooless.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.cooless.R
import me.eugeniomarletti.extras.intent.IntentExtra
import me.eugeniomarletti.extras.intent.base.Serializable
import java.io.Serializable

class ConfirmationActivity : AppCompatActivity() {

    lateinit var offsetDestination: TextView
    lateinit var offsetPurpose: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title = "Confirmation"
        setViews()

        offsetDestination.text = intent.params!!.name
        offsetPurpose.text = intent.params!!.category

        offsetDestination.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(intent.params!!.url));
            startActivity(intent);
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun setViews() {
        offsetDestination = findViewById(R.id.offsetDestination)
        offsetPurpose = findViewById(R.id.offsetPurpose)
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
