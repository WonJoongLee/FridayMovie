package com.movie.home

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.movie.domain.domain.Movie
import com.movie.fridaymovie.core.designsystem.R

@Composable
internal fun PopularMovieItem(movie: Movie) {
    Box(
        modifier = Modifier
            .aspectRatio(27f / 40f)
            .clip(RoundedCornerShape(6.dp))
            .border(
                width = 1.dp,
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
