plugins {
    alias(libs.plugins.fridaymovie.android.library.compose)
    alias(libs.plugins.fridaymovie.android.feature)
    alias(libs.plugins.screenshot)
}

android {
    namespace = "com.movie.home"

    experimentalProperties["android.experimental.enableScreenshotTest"] = true
}

dependencies {
    implementation(projects.core.strings)
    implementation(projects.core.testing)
    implementation(projects.domain)
    implementation(projects.core.designsystem)

    screenshotTestImplementation(libs.androidx.compose.ui.tooling)
}
