package com.movie.network.retrofit

import com.movie.network.dto.PopularMovieResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

internal interface FridayMovieApi {
    @GET("movie/popular")
    suspend fun getPopularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ): PopularMovieResponseDto
}
