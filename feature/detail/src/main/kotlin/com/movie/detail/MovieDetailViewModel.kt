package com.movie.detail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.detail.ui.MovieDetailUiState
import com.movie.domain.domain.Movie
import com.movie.domain.repository.MovieRepository
import com.movie.navigation.DETAIL_MOVIE_ID_PARAMETER
import com.movie.navigation.DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER
import com.movie.navigation.DETAIL_MOVIE_TITLE_PARAMETER
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val repository: MovieRepository,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {

    private val movieId = savedStateHandle.get<Long>(DETAIL_MOVIE_ID_PARAMETER)
    private val posterImageUrl =
        savedStateHandle.get<String>(DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER)
    private val movieTitle = savedStateHandle.get<String>(DETAIL_MOVIE_TITLE_PARAMETER)
    private val _uiState = MutableStateFlow(
        MovieDetailUiState.INITIAL.copy(
            movie = Movie.INITIAL.copy(
                id = movieId ?: -1L,
                title = movieTitle ?: "",
                posterImageUrl = posterImageUrl ?: "",
            )
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            if (movieId != null && movieId != -1L) {
                val movie = repository.getMovie(movieId)
                _uiState.value = MovieDetailUiState(
                    movie = movie
                )
            }
        }
    }
}
