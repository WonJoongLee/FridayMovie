package com.movie.domain.repository

import com.movie.domain.domain.Movie

interface MovieRepository {
    fun getPopularMovies(): List<Movie>
}