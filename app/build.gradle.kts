import com.movie.convention.FridayMovieBuildType

plugins {
    alias(libs.plugins.fridaymovie.android.application)
    alias(libs.plugins.fridaymovie.android.application.compose)
    alias(libs.plugins.fridaymovie.android.application.flavors)
    alias(libs.plugins.fridaymovie.android.hilt)
}

android {
    namespace = "com.movie.fridaymovie"

    defaultConfig {
        applicationId = "com.movie.fridaymovie"
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        debug {
            applicationIdSuffix = FridayMovieBuildType.DEBUG.applicationIdSuffix
        }
        release {
            isMinifyEnabled = false
            applicationIdSuffix = FridayMovieBuildType.RELEASE.applicationIdSuffix
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(projects.data)
    implementation(projects.domain)

    // core
    implementation(projects.core.testing)
    implementation(projects.core.strings)
    implementation(projects.core.designsystem)
    implementation(projects.core.navigation)

    // features
    implementation(projects.feature.home)

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.navigation.testing)

    ksp(libs.hilt.compiler)
    kspTest(libs.hilt.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}