package com.movie.designsystem.core.designsystem.preview

import android.content.res.Configuration
import androidx.annotation.VisibleForTesting
import androidx.compose.ui.tooling.preview.Preview

/**
 * Definitions for MultiThemePreviews
 */
@VisibleForTesting
object MultiThemePreviewDefinition {
    const val Group = "Theme"

    object DarkMode {
        const val Name = "DarkMode"
        const val UiMode = Configuration.UI_MODE_NIGHT_YES
    }

    object LightMode {
        const val Name = "LightMode"
        const val UiMode = Configuration.UI_MODE_NIGHT_NO
    }
}

/**
 * Annotation for previewing multiple themes.
 */
@Preview(
    name = MultiThemePreviewDefinition.LightMode.Name,
    group = MultiThemePreviewDefinition.Group,
    uiMode = MultiThemePreviewDefinition.LightMode.UiMode,
)
@Preview(
    name = MultiThemePreviewDefinition.DarkMode.Name,
    group = MultiThemePreviewDefinition.Group,
    uiMode = MultiThemePreviewDefinition.DarkMode.UiMode,
)
annotation class MultiThemePreviews
