package com.movie.detail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movie.detail.ui.MovieOverView
import com.movie.detail.ui.MovieRate
import com.movie.detail.ui.TopMovieInfo
import com.movie.fridaymovie.core.designsystem.R as DesignSystemR

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                color = colorResource(id = DesignSystemR.color.gray900)
            )
    ) {
        item {
            TopMovieInfo(
                animatedVisibilityScope = animatedVisibilityScope,
                uiState = uiState
            )
        }

        item {
            MovieRate(uiState = uiState)
        }

        item {
            MovieOverView(uiState = uiState)
        }
    }
}
