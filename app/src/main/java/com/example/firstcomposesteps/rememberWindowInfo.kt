package com.example.firstcomposesteps

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun rememberWindowInfo(): WindowInfo {
    val configuration = LocalConfiguration.current
    return WindowInfo(
        screenWidthInfo = when {
            configuration.screenWidthDp < 600 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 840 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expended
        },
        screeHeightInfo = when {
            configuration.screenHeightDp < 480 -> WindowInfo.WindowType.Compact
            configuration.screenWidthDp < 900 -> WindowInfo.WindowType.Medium
            else -> WindowInfo.WindowType.Expended
        },
        screedWidth = configuration.screenWidthDp.dp,
        screedHeight = configuration.screenHeightDp.dp
    )
}

data class WindowInfo(
    val screenWidthInfo: WindowType,
    val screeHeightInfo: WindowType,
    val screedWidth: Dp,
    val screedHeight: Dp
) {
    sealed class WindowType {
        object Compact : WindowType()
        object Medium : WindowType()
        object Expended : WindowType()
    }
}