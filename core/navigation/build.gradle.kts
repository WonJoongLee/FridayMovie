plugins {
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.library)
    alias(libs.plugins.fridaymovie.android.hilt)
}

android {
    namespace = "com.movie.fridaymovie.core.navigation"
}
