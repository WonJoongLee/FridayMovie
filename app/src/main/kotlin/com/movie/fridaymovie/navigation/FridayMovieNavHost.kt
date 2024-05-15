package com.movie.fridaymovie.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.movie.home.HomeScreen
import com.movie.navigation.FridayMovieScreens

@Composable
fun FridayMovieNavHost(
    navHostController: NavHostController
) {
    NavHost(
        navController = navHostController,
        startDestination = FridayMovieScreens.Home.route
    ) {
        composable(route = FridayMovieScreens.Home.name) {
            HomeScreen()
        }

        composable(
            route = FridayMovieScreens.Movie.name,
            arguments = FridayMovieScreens.Movie.navArguments
        ) {
            // todo tbd
        }
    }
}
