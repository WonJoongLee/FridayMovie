plugins {
    alias(libs.plugins.fridaymovie.android.library)
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.hilt)
}

android {
    namespace = "com.movie.fridaymovie.core.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.androidx.compose.ui.test)

    debugApi(libs.androidx.compose.ui.testManifest)

    implementation(libs.androidx.test.rules)
    implementation(libs.hilt.android.testing)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.kotlinx.datetime)
}