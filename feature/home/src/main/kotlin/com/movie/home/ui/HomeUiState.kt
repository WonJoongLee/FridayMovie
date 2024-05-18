package com.movie.home.ui

import com.movie.domain.domain.Movie

data class HomeUiState(
    val isLoading: Boolean,
    val popularMovies: List<Movie>
) {
    companion object {
        val INITIAL: HomeUiState
            get() = HomeUiState(
                isLoading = true,
                popularMovies = emptyList()
            )
    }
}
