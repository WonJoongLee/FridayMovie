package com.movie.detail

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.detail.ui.MovieDetailUiState
import com.movie.domain.repository.MovieRepository
import com.movie.navigation.DETAIL_ITEM_ID_PARAMETER
import com.movie.navigation.DETAIL_ITEM_MOVIE_TITLE_PARAMETER
import com.movie.navigation.DETAIL_ITEM_POSTER_IMAGE_URL_PARAMETER
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

    //    private val movieId = savedStateHandle.getStateFlow(DETAIL_ITEM_ID_PARAMETER, null)
    private val movieId = savedStateHandle.get<Long>(DETAIL_ITEM_ID_PARAMETER)
    private val posterImageUrl =
        savedStateHandle.get<String>(DETAIL_ITEM_POSTER_IMAGE_URL_PARAMETER)
    private val movieTitle = savedStateHandle.get<String>(DETAIL_ITEM_MOVIE_TITLE_PARAMETER)
    private val _uiState = MutableStateFlow(
        MovieDetailUiState.INITIAL.copy(
            id = movieId ?: -1L,
            title = movieTitle ?: "",
            posterImageUrl = posterImageUrl ?: "",
        )
    )
    val uiState = _uiState.asStateFlow()

    init {
        savedStateHandle.keys().forEach {
            Log.e("@@@", "foreach key : ${it} value : ${savedStateHandle.get<String>(it)}")
        }
        Log.e("@@@", "savedStateHandle : ${savedStateHandle.get<String>(DETAIL_ITEM_ID_PARAMETER)}")
        Log.e(
            "@@@",
            "movieId : $movieId, posterImageUrl : $posterImageUrl, movieTitle : $movieTitle"
        )
        Log.e("@@@", "uiState : ${uiState.value}")
        viewModelScope.launch {
            movieId?.let { id ->
                if (id == -1L) return@launch
                val movie = repository.getMovie(id)
                _uiState.value = MovieDetailUiState(
                    id = id,
                    title = movie.title,
                    posterImageUrl = movie.posterImageUrl
                )
            }
        }
    }
}
