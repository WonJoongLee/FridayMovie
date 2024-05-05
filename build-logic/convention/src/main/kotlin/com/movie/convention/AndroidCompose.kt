package com.movie.convention

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            add("implementation", platform(bom))
            add("androidTestImplementation", platform(bom))
        }
    }

    extensions.configure<ComposeCompilerGradlePluginExtension> {
        fun Provider<String>.onlyIfTrue() = flatMap {
            provider {
                it.takeIf(String::toBoolean)
            }
        }

        project.providers.gradleProperty("enableComposeCompilerMetrics")
            .onlyIfTrue().flatMap { rootProject.layout.buildDirectory.dir("compose-metrics") }
            .let(metricsDestination::set)

        project.providers.gradleProperty("enableComposeCompilerReports")
            .onlyIfTrue().flatMap { rootProject.layout.buildDirectory.dir("compose-reports") }
            .let(reportsDestination::set)

        enableStrongSkippingMode.set(true)
    }
}
