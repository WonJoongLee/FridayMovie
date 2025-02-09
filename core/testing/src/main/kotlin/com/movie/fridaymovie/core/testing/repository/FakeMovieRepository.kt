package com.movie.fridaymovie.core.testing.repository

import com.movie.domain.domain.Movie
import com.movie.domain.domain.PopularMovie
import com.movie.domain.repository.MovieRepository

class FakeMovieRepository : MovieRepository {

    override suspend fun getPopularMovies(): List<PopularMovie> {
        return listOf(
            PopularMovie(
                id = 1,
                title = "Joker: Folie à Deux (2024)",
                originalTitle = "Joker: Folie à Deux",
                voteAverage = 8.0,
                voteCount = 1357,
                popularityScore = 12.3,
                overView = "",
                posterImageUrl = "www.google.com",
                backDropImageUrl = "www.google.com",
            ),
            PopularMovie(
                id = 2,
                title = "The Batman (2022)",
                originalTitle = "The Batman",
                voteAverage = 7.4,
                voteCount = 7531,
                popularityScore = 34.5,
                overView = "",
                posterImageUrl = "www.google.com",
                backDropImageUrl = "www.google.com"
            )
        )
    }

    override suspend fun getMovie(movieId: Long): Movie {
        return when (movieId) {
            1L -> {
                Movie(
                    id = 1,
                    title = "Joker: Folie à Deux (2024)",
                    originalTitle = "Joker: Folie à Deux",
                    voteAverage = 8.0,
                    voteCount = 1357,
                    popularityScore = 12.3,
                    overView = "",
                    posterImageUrl = "www.google.com",
                    backDropImageUrl = "www.google.com",
                    status = ""
                )
            }

            2L -> {
                Movie(
                    id = 2,
                    title = "The Batman (2022)",
                    originalTitle = "The Batman",
                    voteAverage = 7.4,
                    voteCount = 7531,
                    popularityScore = 34.5,
                    overView = "",
                    posterImageUrl = "www.google.com",
                    backDropImageUrl = "www.google.com",
                    status = ""
                )
            }

            else -> Movie.INITIAL
        }
    }
}