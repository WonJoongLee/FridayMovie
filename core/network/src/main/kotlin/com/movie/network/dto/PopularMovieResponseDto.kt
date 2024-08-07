package com.movie.network.dto

import com.movie.domain.domain.MOVIE_IMAGE_BASE_URL
import com.movie.domain.domain.PopularMovie
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PopularMovieResponseDto(
    @SerialName("page")
    val page: Long = -1,
    @SerialName("results")
    val results: List<PopularMovieDto> = emptyList(),
) {
    @Serializable
    data class PopularMovieDto(
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
    ) {
        companion object {
            fun PopularMovieDto.toMovieDomain(): PopularMovie {
                return PopularMovie(
                    id = id,
                    title = title,
                    originalTitle = originalTitle,
                    voteAverage = voteAverage,
                    voteCount = voteCount,
                    popularityScore = popularity,
                    overView = overview,
                    posterImageUrl = MOVIE_IMAGE_BASE_URL + posterPath,
                    backDropImageUrl = MOVIE_IMAGE_BASE_URL + backdropPath,
                )
            }
        }
    }
}
