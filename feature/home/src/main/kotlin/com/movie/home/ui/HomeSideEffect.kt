package com.movie.home.ui

sealed interface HomeSideEffect {
    data class ClickMovie(
        val movieId: Long,
        val posterImageUrl: String,
        val movieTitle: String,
    ) : HomeSideEffect
}