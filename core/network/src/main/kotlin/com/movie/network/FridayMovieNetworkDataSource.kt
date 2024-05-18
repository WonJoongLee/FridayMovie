package com.movie.network

import com.movie.network.dto.MovieDetailDto
import com.movie.network.dto.PopularMovieResponseDto

/**
 * Interface representing network calls
 */
interface FridayMovieNetworkDataSource {
    suspend fun getPopularMovies(
        language: String = "en-US",
        page: Int = 1,
    ): PopularMovieResponseDto

    suspend fun getMovie(
        movieId: Long
    ): MovieDetailDto
}
