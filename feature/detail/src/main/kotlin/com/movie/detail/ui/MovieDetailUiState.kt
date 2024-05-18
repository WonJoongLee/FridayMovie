package com.movie.detail.ui

import com.movie.domain.domain.Movie

data class MovieDetailUiState(
    val movie: Movie
) {
    companion object {
        val INITIAL: MovieDetailUiState
            get() = MovieDetailUiState(
                Movie.INITIAL
            )
    }
}