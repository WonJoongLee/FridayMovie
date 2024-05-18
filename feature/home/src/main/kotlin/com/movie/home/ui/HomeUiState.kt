package com.movie.home.ui

import com.movie.domain.domain.PopularMovie

data class HomeUiState(
    val isLoading: Boolean,
    val popularMovies: List<PopularMovie>
) {
    companion object {
        val INITIAL: HomeUiState
            get() = HomeUiState(
                isLoading = true,
                popularMovies = emptyList()
            )
    }
}
