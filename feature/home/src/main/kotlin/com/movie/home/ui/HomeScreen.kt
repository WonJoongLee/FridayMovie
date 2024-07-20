package com.movie.home.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.movie.designsystem.core.designsystem.theme.FridayMovieTheme
import com.movie.fridaymovie.core.strings.R
import com.movie.fridaymovie.core.designsystem.R as DesignSystemR

@OptIn(ExperimentalSharedTransitionApi::class, ExperimentalMaterial3Api::class)
@Composable
fun SharedTransitionScope.HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    animatedVisibilityScope: AnimatedVisibilityScope,
    onClickMovie: (
        movieId: Long,
        posterImageUrl: String,
        movieTitle: String,
    ) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopAppBar(
                modifier = Modifier.fillMaxWidth(),
                colors = TopAppBarDefaults.topAppBarColors().copy(
                    containerColor = colorResource(id = DesignSystemR.color.gray800),
                    scrolledContainerColor = colorResource(id = DesignSystemR.color.gray800)
                ),
                title = {
                    HomeScreenTitle(
                        modifier = Modifier.padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
                    )
                },
                scrollBehavior = scrollBehavior
            )
        },
        containerColor = colorResource(id = DesignSystemR.color.gray800)
    ) { paddingValues ->
        LazyVerticalGrid(
            modifier = Modifier
                .padding(horizontal = 16.dp),
            columns = GridCells.Adaptive(128.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            contentPadding = paddingValues
        ) {
            items(
                items = uiState.popularMovies,
                key = { popularMovie ->
                    popularMovie.id
                }
            ) { popularMovie ->
                PopularMovieItem(
                    movie = popularMovie,
                    onClick = onClickMovie,
                    animatedVisibilityScope = animatedVisibilityScope
                )
            }
        }
    }
}

@Composable
private fun HomeScreenTitle(modifier: Modifier = Modifier) {
    Text(
        modifier = modifier,
        text = stringResource(id = R.string.main_top_app_name),
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        style = TextStyle(
            brush = Brush.horizontalGradient(
                colors = listOf(
                    colorResource(id = DesignSystemR.color.yellow900),
                    colorResource(id = DesignSystemR.color.yellow500)
                ),
            )
        )
    )
}

@Preview(
    showBackground = true,
    backgroundColor = 0xFF424242
)
@Composable
private fun HomeScreenTitlePreview() {
    FridayMovieTheme {
        HomeScreenTitle(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
    }
}