package com.movie.home.ui

import com.movie.fridaymovie.core.testing.repository.FakeMovieRepository
import com.movie.fridaymovie.core.testing.util.MainDispatcherRule
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HomeViewModelTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private lateinit var viewModel: HomeViewModel
    private val movieRepository = FakeMovieRepository()

    @Before
    fun setup() {
        viewModel = HomeViewModel(movieRepository = movieRepository)
    }

    @Test
    fun `Click movie should produce navigate to movie detail`()= runTest {
        val movieId = 1L
        val posterImageUrl = "https://example.com/poster.jpg"
        val movieTitle = "Sample Movie"

        viewModel.onUserIntent(
            HomeUserIntent.ClickMovie(
                movieId = movieId,
                posterImageUrl = posterImageUrl,
                movieTitle = movieTitle
            )
        )

        val sideEffect = viewModel.sideEffect.first()
        assertEquals(
            HomeSideEffect.ClickMovie(
                movieId = movieId,
                posterImageUrl = posterImageUrl,
                movieTitle = movieTitle
            ),
            sideEffect
        )
    }
}