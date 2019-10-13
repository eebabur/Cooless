package com.example.cooless.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.cooless.R
import com.example.cooless.model.Flight

class FlightAdapter(private val onItemClick: (Flight) -> Unit) : RecyclerView.Adapter<FlightAdapter.FlightViewHolder>() {

    private var flights: List<Flight> = emptyList()

    fun updateModel(flights: List<Flight>) {
        this.flights = flights
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder =
        FlightViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_flight, parent, false))

    override fun getItemCount(): Int = flights.size

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        holder.bind(flights[position], onItemClick)
    }

    class FlightViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val emissionAdvantage: TextView = view.findViewById(R.id.emissionAdvantage)
        val airlinePicture: ImageView = view.findViewById(R.id.airlinePicture)
        val airlineName: TextView = view.findViewById(R.id.airlineName)
        val origin: TextView = view.findViewById(R.id.origin)
        val departure: TextView = view.findViewById(R.id.departure)
        val destination: TextView = view.findViewById(R.id.destination)
        val arrival: TextView = view.findViewById(R.id.arrival)
        val price: TextView = view.findViewById(R.id.ticketPrice)
        val leaf: ImageView = view.findViewById(R.id.leaf)

        fun bind(flight: Flight, onItemClick: (Flight) -> Unit) {
            itemView.setOnClickListener { onItemClick(flight) }
            if (flight.emissionAdvantage != null) {
                emissionAdvantage.text = "${flight.emissionAdvantage}% lower CO2 emission"
                emissionAdvantage.visibility = View.VISIBLE
                leaf.visibility = View.VISIBLE
            } else {
                emissionAdvantage.visibility = View.GONE
                leaf.visibility = View.GONE
            }
            Glide.with(airlinePicture).load(flight.airlinePicture).into(airlinePicture);
            airlineName.text = flight.airlineName
            origin.text = flight.origin
            departure.text = flight.departure
            destination.text = flight.destination
            arrival.text = flight.arrival
            price.text = flight.price
        }
    }
}