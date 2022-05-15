package com.example.chucknorrisjokeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class JokeAdapter(private val jokeList : ArrayList<Items>) :
    RecyclerView.Adapter<JokeAdapter.JokeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.joke_layout, parent, false)
        return JokeViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val item = jokeList[position]
        holder.titleImage.setImageResource(item.titleImage)
        holder.jokeHeading.text = item.jokeHeading
    }

    override fun getItemCount(): Int {
        return jokeList.size
    }

    class JokeViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val titleImage : ImageView = itemView.findViewById(R.id.title_image)
        val jokeHeading : TextView = itemView.findViewById(R.id.joke_heading)

    }



}