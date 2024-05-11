package com.movie.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.movie.strings.R

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    Text(text = stringResource(id = R.string.main_top_app_name))
}
