package com.movie.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState.INITIAL)
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = Channel<HomeSideEffect>()
    val sideEffect = _sideEffect.receiveAsFlow()

    init {
        viewModelScope.launch {
            runCatching {
                movieRepository.getPopularMovies()
            }.onSuccess { movieList ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        popularMovies = movieList
                    )
                }
            }
        }
    }

    fun onUserIntent(userIntent: HomeUserIntent) {
        when (userIntent) {
            is HomeUserIntent.ClickMovie -> {
                clickMovie(
                    movieId = userIntent.movieId,
                    posterImageUrl = userIntent.posterImageUrl,
                    movieTitle = userIntent.movieTitle,
                )
            }
        }
    }

    private fun produceSideEffect(sideEffect: HomeSideEffect) {
        viewModelScope.launch { _sideEffect.send(sideEffect) }
    }

    private fun clickMovie(movieId: Long, posterImageUrl: String, movieTitle: String) {
        produceSideEffect(
            HomeSideEffect.ClickMovie(
                movieId = movieId,
                posterImageUrl = posterImageUrl,
                movieTitle = movieTitle,
            )
        )
    }
}
