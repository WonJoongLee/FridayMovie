import java.util.Properties

plugins {
    alias(libs.plugins.fridaymovie.android.library)
    alias(libs.plugins.fridaymovie.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.movie.fridaymovie.core.network"

    defaultConfig {
        val secretProperties = Properties()
        val secretsPropertiesFile: File = project.rootProject.file("secrets.properties")
        if (secretsPropertiesFile.exists()) {
            secretProperties.load(secretsPropertiesFile.inputStream())
            buildConfigField("String", "TMDB_API_KEY", "\"${secretProperties["TMDB_API_KEY"]}\"")
        }
    }

    buildFeatures {
        buildConfig = true
    }
}

dependencies {
    implementation(projects.domain)

    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
}