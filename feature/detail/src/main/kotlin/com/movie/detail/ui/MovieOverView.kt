package com.movie.detail.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.movie.fridaymovie.core.designsystem.R

@Composable
internal fun MovieOverView(uiState: MovieDetailUiState) {
    Text(
        text = uiState.movie.overView,
        fontSize = 14.sp,
        color = colorResource(id = R.color.gray50),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
    )
}