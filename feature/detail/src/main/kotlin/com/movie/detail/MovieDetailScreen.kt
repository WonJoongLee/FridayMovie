package com.movie.detail

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.MovieDetailScreen(
    viewModel: MovieDetailViewModel = hiltViewModel(),
    animatedVisibilityScope: AnimatedVisibilityScope,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column {
        AsyncImage(
            modifier = Modifier
                .sharedElement(
                    state = rememberSharedContentState(key = uiState.posterImageUrl),
                    animatedVisibilityScope = animatedVisibilityScope,
                ),
            model = uiState.posterImageUrl,
            contentDescription = null,
        )

        Text(
            modifier = Modifier.sharedBounds(
                sharedContentState = rememberSharedContentState(key = uiState.title),
                animatedVisibilityScope = animatedVisibilityScope
            ),
            text = uiState.title
        )
    }
}
