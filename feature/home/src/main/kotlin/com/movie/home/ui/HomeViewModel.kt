package com.movie.home.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
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

    fun clickMovie(movieId: Long) {

    }
}
