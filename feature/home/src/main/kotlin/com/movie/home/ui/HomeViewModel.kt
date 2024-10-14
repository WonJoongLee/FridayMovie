package com.movie.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState.INITIAL)
    val uiState = _uiState.asStateFlow()

    private val _sideEffect = MutableSharedFlow<HomeSideEffect>()
    val sideEffect = _sideEffect.asSharedFlow()

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

    private fun emitSideEffect(sideEffect: HomeSideEffect) {
        viewModelScope.launch { _sideEffect.emit(sideEffect) }
    }

    private fun clickMovie(movieId: Long, posterImageUrl: String, movieTitle: String) {
        emitSideEffect(
            HomeSideEffect.ClickMovie(
                movieId = movieId,
                posterImageUrl = posterImageUrl,
                movieTitle = movieTitle,
            )
        )
    }
}
