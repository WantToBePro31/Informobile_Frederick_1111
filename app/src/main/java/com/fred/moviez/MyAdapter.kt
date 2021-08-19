package com.fred.moviez

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter(private val List: ArrayList<Film>, val listener: (Film) -> Unit) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val titleImage : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val textTitle: TextView = itemView.findViewById(R.id.textTitle)
        val age : TextView = itemView.findViewById(R.id.age_rate)
        val genre : TextView = itemView.findViewById(R.id.film_genre)
        fun bindView(film: Film, listener: (Film) -> Unit){
            titleImage.setImageResource(film.titleImage)
            textTitle.text = film.textTitle
            age.text = film.ageRating
            genre.text = film.genreFilm
            itemView.setOnClickListener { listener(film) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.activity_list_film,parent,false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(List[position], listener)
    }

    override fun getItemCount(): Int {
        return List.size
    }
}