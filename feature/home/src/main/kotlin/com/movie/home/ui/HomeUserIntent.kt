package com.movie.home.ui

sealed interface HomeUserIntent {
    data class ClickMovie(
        val movieId: Long,
        val posterImageUrl: String,
        val movieTitle: String,
    ) : HomeUserIntent
}