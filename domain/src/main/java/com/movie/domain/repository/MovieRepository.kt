package com.movie.domain.repository

import com.movie.domain.domain.Movie

interface MovieRepository {
    suspend fun getPopularMovies(): List<Movie>
}