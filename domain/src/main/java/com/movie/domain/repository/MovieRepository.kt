package com.movie.domain.repository

import com.movie.domain.domain.Movie
import com.movie.domain.domain.PopularMovie

interface MovieRepository {
    suspend fun getPopularMovies(): List<PopularMovie>
    suspend fun getMovie(movieId: Long): Movie
}