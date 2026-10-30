package com.example.androidapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

@Composable
fun AndroidAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColorScheme(
            primary = DarkThemeColors.primary,
            onPrimary = DarkThemeColors.onPrimary,
            background = DarkThemeColors.background,
            onBackground = DarkThemeColors.onBackground,
            surface = DarkThemeColors.surface,
            onSurface = DarkThemeColors.onSurface,
            error = DarkThemeColors.error
        )
    } else {
        lightColorScheme(
            primary = LightThemeColors.primary,
            onPrimary = LightThemeColors.onPrimary,
            background = LightThemeColors.background,
            onBackground = LightThemeColors.onBackground,
            surface = LightThemeColors.surface,
            onSurface = LightThemeColors.onSurface,
            error = LightThemeColors.error
        )
    }

    MaterialTheme(
        colorScheme = colors,
        typography = AppTypography,
        content = content
    )
}