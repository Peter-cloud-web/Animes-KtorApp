package com.example.heroesapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val Green500 = Color(0xFF00FFDE)
val Green700 = Color(0xFF00E7FF)

val LightGray = Color(0xFFD8D8D8)
val DarkGray = Color(0xFF2A2A2A)

val green = Color(0xFF61E4D8)
val fadeGreen = Color(0xFF76DF7A)

val Black = Color(0xFF000000)
val White = Color(0xFFFFFFFF)

val ColorScheme.welcomeScreenBackgroundColor
    @Composable
    get() = if (!isSystemInDarkTheme()) Color.White else Color.Black

val ColorScheme.titleColor
    @Composable
    get() = if (!isSystemInDarkTheme()) DarkGray else LightGray

val ColorScheme.descriptionColor
    @Composable
    get() = if (!isSystemInDarkTheme()) DarkGray.copy(alpha = 0.5f)
    else LightGray.copy(alpha = 0.5f)

val ColorScheme.activeIndicatorColor
@Composable
get() = if(!isSystemInDarkTheme()) Green500 else Green700

val ColorScheme.inActiveIndicatorColor
    @Composable
    get() = if(!isSystemInDarkTheme()) LightGray else DarkGray

val ColorScheme.buttonBackgroundColor
    @Composable
    get() = if(!isSystemInDarkTheme()) green else fadeGreen

val ColorScheme.buttonTextColor
    @Composable
    get() = if(!isSystemInDarkTheme()) Black else White



