package com.movie.fridaymovie.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FridayMovieApp() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {

                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier.padding(padding)
        ) {

        }
    }
}