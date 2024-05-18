package com.movie.network.retrofit

import androidx.tracing.trace
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.movie.network.FridayMovieNetworkDataSource
import com.movie.network.dto.MovieDetailDto
import com.movie.network.dto.PopularMovieResponseDto
import kotlinx.serialization.json.Json
import okhttp3.Call
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

private const val TMDB_BASE_URL = "https://api.themoviedb.org/3/"

@Singleton
internal class FridayMovieRetrofitNetwork @Inject constructor(
    networkJson: Json,
    okhttpCallFactory: dagger.Lazy<Call.Factory>,
) : FridayMovieNetworkDataSource {
    private val networkApi = trace("FridayMovieRetrofitNetwork") {
        Retrofit.Builder()
            .baseUrl(TMDB_BASE_URL)
            .callFactory { okhttpCallFactory.get().newCall(it) }
            .addConverterFactory(
                networkJson.asConverterFactory("application/json".toMediaType()),
            )
            .build()
            .create(FridayMovieApi::class.java)
    }

    override suspend fun getPopularMovies(
        language: String,
        page: Int,
    ): PopularMovieResponseDto {
        return networkApi.getPopularMovies(
            language = language,
            page = page,
        )
    }

    override suspend fun getMovie(movieId: Long): MovieDetailDto {
        return networkApi.getMovie(
            movieId = movieId
        )
    }
}
