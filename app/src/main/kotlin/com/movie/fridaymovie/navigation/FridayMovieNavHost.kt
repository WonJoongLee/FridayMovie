package com.movie.fridaymovie.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.movie.detail.MovieDetailScreen
import com.movie.detail.navigation.navigateToMovieDetail
import com.movie.home.ui.HomeScreen
import com.movie.navigation.FridayMovieScreens

@OptIn(ExperimentalSharedTransitionApi::class)
@Composable
fun FridayMovieNavHost(navHostController: NavHostController) {
    SharedTransitionLayout {
        NavHost(
            navController = navHostController,
            startDestination = FridayMovieScreens.Home.route
        ) {
            composable(route = FridayMovieScreens.Home.route) {
                HomeScreen(
                    animatedVisibilityScope = this@composable,
                    onClickMovie = navHostController::navigateToMovieDetail
                )
            }

            composable(
                route = FridayMovieScreens.Detail.name,
                arguments = FridayMovieScreens.Detail.navArguments
            ) {
                MovieDetailScreen(
                    animatedVisibilityScope = this@composable,
                )
            }
        }
    }
}
