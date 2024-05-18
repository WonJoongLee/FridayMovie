package com.movie.detail.navigation

import android.util.Log
import androidx.navigation.NavController
import com.movie.navigation.FridayMovieScreens

fun NavController.navigateToMovieDetail(
    movieId: Long,
    posterImageUrl: String,
    movieTitle: String,
) {
    Log.e("@@@", "navigateToDetail, movieId: $movieId, posterImageUrl: $posterImageUrl, movieTitle: $movieTitle")
    val temp = FridayMovieScreens.Detail.createRoute(
        movieId = movieId,
        posterImageUrl = posterImageUrl,
        movieTitle = movieTitle,
    )
    Log.e("@@@", "navigateToDetail route : $temp")
    navigate(
        FridayMovieScreens.Detail.createRoute(
            movieId = movieId,
            posterImageUrl = posterImageUrl,
            movieTitle = movieTitle,
        )
    )
}
