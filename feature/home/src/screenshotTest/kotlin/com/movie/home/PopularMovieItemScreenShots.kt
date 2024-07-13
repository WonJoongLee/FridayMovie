package com.movie.home

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movie.designsystem.core.designsystem.theme.FridayMovieTheme
import com.movie.domain.domain.PopularMovie
import com.movie.home.ui.PopularMovieItem

class PopularMovieItemScreenShots {

    @OptIn(ExperimentalSharedTransitionApi::class)
    @Preview(
        showBackground = true
    )
    @Composable
    fun PopularMovieItemScreenShotPreview() {
        val samplePopularMovie = PopularMovie(
            id = 1,
            title = "Joker: Folie à Deux (2024)",
            originalTitle = "Joker: Folie à Deux (2024)",
            voteAverage = 8.54,
            voteCount = 145,
            popularityScore = 0.0,
            overView = "",
            posterImageUrl = "",
            backDropImageUrl = ""
        )
        FridayMovieTheme {
            SharedTransitionLayout {
                AnimatedContent(
                    targetState = 100,
                    label = ""
                ) { _ ->
                    PopularMovieItem(
                        modifier = Modifier.width(100.dp),
                        animatedVisibilityScope = this,
                        movie = samplePopularMovie,
                        onClick = { _, _, _ -> }
                    )
                }
            }
        }
    }
}
