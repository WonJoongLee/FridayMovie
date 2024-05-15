package com.movie.home

import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.movie.designsystem.core.designsystem.theme.FridayMovieTheme
import com.movie.domain.domain.Movie

class PopularMovieItemScreenShots {

    @Preview(
        showBackground = true
    )
    @Composable
    fun PopularMovieItemScreenShotPreview() {
        val samplePopularMovie = Movie(
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
            PopularMovieItem(
                modifier = Modifier.width(100.dp),
                movie = samplePopularMovie
            )
        }
    }
}
