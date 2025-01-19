plugins {
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.library)
    alias(libs.plugins.fridaymovie.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.movie.fridaymovie.core.navigation"
}

dependencies {
    implementation(libs.kotlinx.serialization.json)
}