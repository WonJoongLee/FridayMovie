package com.movie.fridaymovie.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.movie.designsystem.core.designsystem.theme.FridayMovieTheme
import com.movie.fridaymovie.navigation.FridayMovieNavHost

@Composable
fun FridayMovieMain() {
    FridayMovieTheme {
        val navHostController = rememberNavController()
        FridayMovieNavHost(navHostController = navHostController)
    }
}
