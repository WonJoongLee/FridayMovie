package com.movie.domain.domain

data class PopularMovie(
    val id: Long,
    val title: String,
    val originalTitle: String,
    val voteAverage: Double,
    val voteCount: Int,
    val popularityScore: Double,
    val overView: String,
    val posterImageUrl: String,
    val backDropImageUrl: String,
) {
    companion object {
        val INITIAL = PopularMovie(
            id = -1,
            title = "",
            originalTitle = "",
            voteAverage = 0.0,
            voteCount = 0,
            popularityScore = 0.0,
            overView = "",
            posterImageUrl = "",
            backDropImageUrl = "",
        )
    }
}
