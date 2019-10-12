package com.example.cooless.ui

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.cooless.R

class MainActivity : AppCompatActivity() {

    lateinit var from: TextView
    lateinit var to: TextView
    lateinit var date: TextView
    lateinit var searchButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setViews()
        date.setOnClickListener { showDatePickerDialog() }
        searchButton.setOnClickListener { startSearch() }
    }

    private fun setViews() {
        from = findViewById(R.id.from)
        to = findViewById(R.id.to)
        date = findViewById(R.id.date)
        searchButton = findViewById(R.id.searchButton)
    }

    private fun showDatePickerDialog() {
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, dayOfMonth -> date.text = "$dayOfMonth-$month-$year" }
        dialog.show()
    }

    private fun startSearch() {
        val intent = FlightsActivity.createIntent(this, FlightsActivity.SearchParams(from.text.toString(), to.text.toString(), date.text.toString()))
        startActivity(intent)
    }
}
