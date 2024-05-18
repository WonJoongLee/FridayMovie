package com.movie.network.dto

import com.movie.domain.domain.MOVIE_IMAGE_BASE_URL
import com.movie.domain.domain.Movie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieDetailDto(
    @SerialName("id")
    val id: Long = -1,
    @SerialName("original_title")
    val originalTitle: String = "",
    @SerialName("overview")
    val overview: String = "",
    @SerialName("popularity")
    val popularity: Double = 0.0,
    @SerialName("title")
    val title: String = "",
    @SerialName("vote_average")
    val voteAverage: Double = 0.0,
    @SerialName("vote_count")
    val voteCount: Int = -1,
    @SerialName("backdrop_path")
    val backdropPath: String = "",
    @SerialName("poster_path")
    val posterPath: String = "",
    @SerialName("status")
    val status: String = ""
) {
    companion object {
        fun MovieDetailDto.toMovieDomain(): Movie {
            return Movie(
                id = id,
                title = title,
                originalTitle = originalTitle,
                voteAverage = voteAverage,
                voteCount = voteCount,
                popularityScore = popularity,
                overView = overview,
                posterImageUrl = MOVIE_IMAGE_BASE_URL + posterPath,
                backDropImageUrl = MOVIE_IMAGE_BASE_URL + backdropPath,
                status = status
            )
        }
    }
}
