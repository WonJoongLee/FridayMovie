package com.movie.data

import com.movie.domain.domain.Movie
import com.movie.domain.repository.MovieRepository
import com.movie.network.FridayMovieNetworkDataSource
import com.movie.network.dto.MovieDetailDto.Companion.toMovieDomain
import com.movie.network.dto.PopularMovieResponseDto.PopularMovieDto.Companion.toMovieDomain
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val networkDataSource: FridayMovieNetworkDataSource,
) : MovieRepository {
    override suspend fun getPopularMovies(): List<Movie> {
        return networkDataSource.getPopularMovies().results.map {
            it.toMovieDomain()
        }
    }

    override suspend fun getMovie(movieId: Long): Movie {
        return networkDataSource.getMovie(movieId).toMovieDomain()
    }
}
