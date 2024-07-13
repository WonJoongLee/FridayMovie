package com.movie.detail.navigation

import androidx.navigation.NavController
import com.movie.navigation.FridayMovieScreens

fun NavController.navigateToMovieDetail(
    movieId: Long,
    posterImageUrl: String,
    movieTitle: String,
) {
    navigate(
        FridayMovieScreens.Detail.createRoute(
            movieId = movieId,
            posterImageUrl = posterImageUrl,
            movieTitle = movieTitle,
        )
    )
}
