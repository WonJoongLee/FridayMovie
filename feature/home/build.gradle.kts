plugins {
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.feature)
}

android {
    namespace = "com.movie.home"
}

dependencies {
    implementation(projects.core.strings)
    implementation(projects.core.testing)
}
