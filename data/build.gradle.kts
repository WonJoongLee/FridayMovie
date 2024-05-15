plugins {
    alias(libs.plugins.fridaymovie.android.library)
    alias(libs.plugins.fridaymovie.android.hilt)
}

android {
    namespace = "com.movie.fridaymovie.data"
}

dependencies {
    implementation(projects.domain)
    implementation(projects.core.network)
}