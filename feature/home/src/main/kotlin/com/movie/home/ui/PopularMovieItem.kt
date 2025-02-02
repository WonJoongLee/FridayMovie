package com.movie.home.ui

import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.movie.designsystem.core.designsystem.theme.FridayMovieTheme
import com.movie.domain.domain.PopularMovie
import com.movie.fridaymovie.core.designsystem.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
internal fun SharedTransitionScope.PopularMovieItem(
    modifier: Modifier = Modifier,
    animatedVisibilityScope: AnimatedVisibilityScope,
    movie: PopularMovie,
    onClick: (
        movieId: Long,
        posterImageUrl: String,
        movieTitle: String,
    ) -> Unit,
) {
    Box(
        modifier = modifier
            .sharedElement(
                state = rememberSharedContentState(key = movie.posterImageUrl),
                animatedVisibilityScope = animatedVisibilityScope
            )
            .clickable {
                onClick(movie.id, movie.posterImageUrl, movie.title)
            }
            .aspectRatio(27f / 40f)
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 2.dp,
                color = colorResource(id = R.color.gray700),
                shape = RoundedCornerShape(6.dp)
            )
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxHeight(),
            model = movie.posterImageUrl,
            contentScale = ContentScale.Crop,
            contentDescription = null
        )

        Text(
            text = movie.title,
            color = colorResource(id = R.color.gray50),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .sharedBounds(
                    sharedContentState = rememberSharedContentState(key = movie.title),
                    animatedVisibilityScope = animatedVisibilityScope
                )
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
                .padding(start = 4.dp, end = 4.dp, bottom = 2.dp)
        )
    }
}

// should fix preview not showing correctly because of SharedTransitionScope
@OptIn(ExperimentalSharedTransitionApi::class)
@SuppressLint("UnusedContentLambdaTargetStateParameter")
@Preview(
    showBackground = true
)
@Composable
private fun PopularMovieItemPreview() {
    val samplePopularMovie = PopularMovie(
        id = 1,
        title = "Joker: Folie à Deux (2024)",
        originalTitle = "",
        voteAverage = 8.54,
        voteCount = 145,
        popularityScore = 0.0,
        overView = "",
        posterImageUrl = "",
        backDropImageUrl = "",
    )
    FridayMovieTheme {
        SharedTransitionScope {
            AnimatedContent(
                targetState = 100,
                label = ""
            ) { _ ->
                PopularMovieItem(
                    movie = samplePopularMovie,
                    animatedVisibilityScope = this,
                    onClick = { _, _, _ -> }
                )
            }
        }
    }
}
