package com.movie.domain.domain

data class Movie(
    val id: Long,
    val title: String,
    val originalTitle: String,
    val voteAverage: Double,
    val voteCount: Int,
    val popularityScore: Double,
    val overView: String,
    val posterImageUrl: String,
    val backDropImageUrl: String,
    val status: String,
) {
    companion object {
        val INITIAL = Movie(
            id = -1,
            title = "",
            originalTitle = "",
            voteAverage = 0.0,
            voteCount = 0,
            popularityScore = 0.0,
            overView = "",
            posterImageUrl = "",
            backDropImageUrl = "",
            status = ""
        )
    }
}
