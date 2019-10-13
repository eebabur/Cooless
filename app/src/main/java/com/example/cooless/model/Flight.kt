package com.example.cooless.model

data class Flight(
    val airlineName: String,
    val date: String,
    val origin: String,
    val departure: String,
    val destination: String,
    val arrival: String,
    val price: String,
    val emissionAdvantage: Int? = null
)