package com.movie.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class FridayMovieScreens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    data object Home : FridayMovieScreens(route = "home")

    data object Movie : FridayMovieScreens(
        route = "movie",
        navArguments = listOf(
            navArgument("movieId") {
                type = NavType.IntType
                nullable = false
            }
        )
    ) {
        // todo 실제로 어떻게 찍히는 지 확인해보기
        fun createRoute(movieId: Int): String =
            name.replace("{${navArguments.first().name}}", movieId.toString())
    }
}

private fun String.appendArguments(navArguments: List<NamedNavArgument>): String {
    val mandatoryArguments = navArguments.filter { it.argument.defaultValue == null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
        .orEmpty()
    val optionalArguments = navArguments.filter { it.argument.defaultValue != null }
        .takeIf { it.isNotEmpty() }
        ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
        .orEmpty()
    return "$this$mandatoryArguments$optionalArguments"
}
