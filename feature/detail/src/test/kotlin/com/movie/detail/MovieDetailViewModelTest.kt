package com.movie.detail

import androidx.lifecycle.SavedStateHandle
import com.movie.fridaymovie.core.testing.repository.FakeMovieRepository
import com.movie.fridaymovie.core.testing.util.MainDispatcherRule
import com.movie.navigation.DETAIL_MOVIE_ID_PARAMETER
import com.movie.navigation.DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER
import com.movie.navigation.DETAIL_MOVIE_TITLE_PARAMETER
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import kotlin.test.Test

class MovieDetailViewModelTest {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()
    private val repository = FakeMovieRepository()

    @Test
    fun `ViewModel initializes with correct movie details`() = runTest {
        val movieId = 1L
        val posterImageUrl = "www.google.com"
        val movieTitle = "Joker: Folie à Deux (2024)"
        val viewModel = getViewModel(
            movieId = movieId,
            posterImageUrl = posterImageUrl,
            movieTitle = movieTitle
        )

        val uiState = viewModel.uiState.value
        assertEquals(movieId, uiState.movie.id)
        assertEquals(movieTitle, uiState.movie.title)
        assertEquals(posterImageUrl, uiState.movie.posterImageUrl)
    }

    private fun getViewModel(
        movieId: Long,
        posterImageUrl: String,
        movieTitle: String,
    ): MovieDetailViewModel {
        val savedStateHandle = SavedStateHandle(
            mapOf(
                DETAIL_MOVIE_ID_PARAMETER to movieId,
                DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER to posterImageUrl,
                DETAIL_MOVIE_TITLE_PARAMETER to movieTitle
            )
        )
        return MovieDetailViewModel(
            repository = repository,
            savedStateHandle = savedStateHandle
        )
    }
}