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
)
