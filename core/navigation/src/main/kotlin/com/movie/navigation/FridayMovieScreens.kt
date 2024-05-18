package com.movie.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

const val DETAIL_ITEM_ID_PARAMETER = "movieId"
const val DETAIL_ITEM_POSTER_IMAGE_URL_PARAMETER = "posterImageUrl"
const val DETAIL_ITEM_MOVIE_TITLE_PARAMETER = "movieTitle"

sealed class FridayMovieScreens(
    val route: String,
    val navArguments: List<NamedNavArgument> = emptyList()
) {
    val name: String = route.appendArguments(navArguments)

    data object Home : FridayMovieScreens(route = "home")

    data object Detail : FridayMovieScreens(
        route = "detail",
        navArguments = listOf(
            navArgument(DETAIL_ITEM_ID_PARAMETER) {
                type = NavType.LongType
                nullable = false
                defaultValue = -1L
            },
            navArgument(DETAIL_ITEM_POSTER_IMAGE_URL_PARAMETER) {
                type = NavType.StringType
                nullable = false
                defaultValue = ""
            },
            navArgument(DETAIL_ITEM_MOVIE_TITLE_PARAMETER) {
                type = NavType.StringType
                nullable = false
                defaultValue = ""
            },
        )
    ) {
        fun createRoute(
            movieId: Long,
            posterImageUrl: String,
            movieTitle: String,
        ): String =
            "detail?$DETAIL_ITEM_ID_PARAMETER=$movieId" +
                    "&$DETAIL_ITEM_POSTER_IMAGE_URL_PARAMETER=$posterImageUrl" +
                    "&$DETAIL_ITEM_MOVIE_TITLE_PARAMETER=$movieTitle"
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
