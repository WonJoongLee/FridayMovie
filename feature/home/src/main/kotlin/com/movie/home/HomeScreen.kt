package com.movie.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.movie.fridaymovie.core.strings.R

@Composable
fun HomeScreen() {
    Text(text = stringResource(id = R.string.main_top_app_name))
}
