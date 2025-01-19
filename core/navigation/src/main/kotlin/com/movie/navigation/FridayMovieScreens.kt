package com.movie.navigation

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

const val DETAIL_MOVIE_ID_PARAMETER = "movie_id"
const val DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER = "poster_image_url"
const val DETAIL_MOVIE_TITLE_PARAMETER = "movie_title"

@Serializable
abstract class FridayMovieScreens(val route: String) {
    @Serializable
    data object Home : FridayMovieScreens(route = "home")

    @Serializable
    data class Detail(
        @SerialName(DETAIL_MOVIE_ID_PARAMETER)
        val movieId: Long = -1L,
        @SerialName(DETAIL_MOVIE_POSTER_IMAGE_URL_PARAMETER)
        val posterImageUrl: String = "",
        @SerialName(DETAIL_MOVIE_TITLE_PARAMETER)
        val movieTitle: String = "",
    ) : FridayMovieScreens(route = "detail")
}
