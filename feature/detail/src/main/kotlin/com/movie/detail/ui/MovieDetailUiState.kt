package com.movie.detail.ui

data class MovieDetailUiState(
    val id: Long,
    val title: String,
    val posterImageUrl: String
) {
    companion object {
        val INITIAL: MovieDetailUiState
            get() = MovieDetailUiState(
                id = -1,
                title = "",
                posterImageUrl = ""
            )
    }
}