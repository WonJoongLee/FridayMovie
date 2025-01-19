package com.movie.fridaymovie.navigation

import androidx.compose.animation.ExperimentalSharedTransitionApi
import androidx.compose.animation.SharedTransitionLayout
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.movie.detail.MovieDetailScreen
import com.movie.home.ui.HomeRoute
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
                HomeRoute(
                    animatedVisibilityScope = this@composable,
                    onClickMovie = { movieId: Long, posterImageUrl: String, movieTitle: String ->
                        navHostController.navigate(
                            FridayMovieScreens.Detail(
                                movieId = movieId,
                                posterImageUrl = posterImageUrl,
                                movieTitle = movieTitle
                            )
                        )
                    }
                )
            }

            composable<FridayMovieScreens.Detail> {
                MovieDetailScreen(animatedVisibilityScope = this@composable)
            }
        }
    }
}
