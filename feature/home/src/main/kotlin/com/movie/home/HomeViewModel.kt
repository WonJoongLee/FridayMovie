package com.movie.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.movie.domain.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val movieRepository: MovieRepository,
) : ViewModel() {
    init {
        viewModelScope.launch {
            val movieList = movieRepository.getPopularMovies()
        }
    }
}
