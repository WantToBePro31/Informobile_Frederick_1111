package com.fred.moviez

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Film(
    var titleImage: Int,
    var textTitle: String,
    var ageRating: String,
    var genreFilm: String,
    var trailerFilm: String,
    var durationFilm: String,
    var directorFilm: String,
    var releaseFilm: String,
//    var ratingFilm: String,
    var descFilm: String
    ) : Parcelable{
}
