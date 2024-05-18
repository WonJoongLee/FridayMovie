package com.movie.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.movie.home.ui.HomeScreen
import com.movie.navigation.FridayMovieScreens

fun NavController.navigateToHome() = navigate(FridayMovieScreens.Home.route)
