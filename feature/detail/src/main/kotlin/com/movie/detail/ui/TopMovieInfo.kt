package com.movie.detail.ui

import androidx.compose.animation.AnimatedVisibilityScope
import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionScope
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.movie.fridaymovie.core.designsystem.R

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun SharedTransitionScope.TopMovieInfo(
    animatedVisibilityScope: AnimatedVisibilityScope,
    uiState: MovieDetailUiState,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(360.dp)
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = uiState.movie.backDropImageUrl,
            contentScale = ContentScale.FillHeight,
            contentDescription = null,
        )

        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            colorResource(id = R.color.transparent),
                            colorResource(id = R.color.gray900),
                        )
                    )
                ),
        )

        Row(
            modifier = Modifier
                .align(Alignment.BottomStart)
                .height(180.dp)
                .padding(start = 16.dp, bottom = 16.dp, end = 16.dp)
        ) {
            AsyncImage(
                modifier = Modifier
                    .sharedElement(
                        state = rememberSharedContentState(key = uiState.movie.posterImageUrl),
                        animatedVisibilityScope = animatedVisibilityScope,
                    )
                    .fillMaxHeight()
                    .aspectRatio(27f / 40f)
                    .clip(RoundedCornerShape(10.dp))
                    .border(
                        width = (1.6).dp,
                        color = colorResource(id = R.color.gray900),
                        shape = RoundedCornerShape(10.dp)
                    ),
                model = uiState.movie.posterImageUrl,
                contentScale = ContentScale.FillWidth,
                contentDescription = null,
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                modifier = Modifier
                    .sharedBounds(
                        sharedContentState = rememberSharedContentState(key = uiState.movie.title),
                        animatedVisibilityScope = animatedVisibilityScope
                    )
                    .align(Alignment.Bottom),
                text = uiState.movie.title,
                color = colorResource(id = R.color.gray50),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
