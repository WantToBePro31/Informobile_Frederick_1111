package com.fred.moviez

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fred.moviez.databinding.ActivityFilmDescriptionBinding
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener


class FilmDescription : AppCompatActivity() {

    var trailerId: String? = null
    private lateinit var binding: ActivityFilmDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val film = intent.getParcelableExtra<Film>(ListFilm.INTENT_PARCELABLE)
        binding = ActivityFilmDescriptionBinding.inflate(layoutInflater)
        if (film != null) {
            binding.titleImage.setImageResource(film.titleImage)
            binding.textTitle.text = film.textTitle
            binding.ageRate.text = film.ageRating
            binding.filmGenre.text = film.genreFilm
            binding.filmDuration.text = film.durationFilm
            binding.filmDirector.text = film.directorFilm
            binding.releaseDate.text = film.releaseFilm
            binding.textDesc.text = film.descFilm
            trailerId = film.trailerFilm
        }
        lifecycle.addObserver(binding.trailerId)
        binding.trailerId.addYouTubePlayerListener(object : AbstractYouTubePlayerListener() {
            override fun onReady(youTubePlayer: YouTubePlayer) {
                val videoId = trailerId
                youTubePlayer.loadVideo(videoId!!, 0f)
            }
        })
        setContentView(binding.root)
    }
}