plugins {
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.feature)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.movie.fridaymovie.feature.detail"

    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    implementation(projects.core.strings)
    implementation(projects.core.testing)
    implementation(projects.core.navigation)
    implementation(projects.core.designsystem)
    implementation(projects.domain)

    screenshotTestImplementation(libs.androidx.compose.ui.tooling)
}