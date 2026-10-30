package com.example.androidapp.ui.theme

import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2F0)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6750A4)
val PurpleGrey40 = Color(0xFF625B71)
val Pink40 = Color(0xFF7D5260)

@Stable
interface ThemeColors {
    val primary: Color
    val onPrimary: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color
    val error: Color
}

object LightThemeColors : ThemeColors {
    override val primary: Color = Purple40
    override val onPrimary: Color = Color.White
    override val background: Color = Color(0xFFFFFBFF)
    override val onBackground: Color = Color(0xFF1C1B1F)
    override val surface: Color = Color(0xFFFFFBFF)
    override val onSurface: Color = Color(0xFF1C1B1F)
    override val error: Color = Color(0xFFBA1A1A)
}

object DarkThemeColors : ThemeColors {
    override val primary: Color = Purple80
    override val onPrimary: Color = Color(0xFF37294B)
    override val background: Color = Color(0xFF1C1B1F)
    override val onBackground: Color = Color(0xFFE6E1E5)
    override val surface: Color = Color(0xFF1C1B1F)
    override val onSurface: Color = Color(0xFFE6E1E5)
    override val error: Color = Color(0xFFFFB4AB)
}