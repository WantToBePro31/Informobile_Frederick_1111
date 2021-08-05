package com.fred.moviez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val List: ArrayList<New>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val rating : TextView = itemView.findViewById(R.id.film_rate)
        val genre : TextView = itemView.findViewById(R.id.film_genre)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_film,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = List[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.textTitle.text = currentItem.textTitle
        holder.rating.text = currentItem.ratingFilm
        holder.genre.text = currentItem.genreFilm
    }

    override fun getItemCount(): Int {
        return List.size
    }
}