package ctorres.developer.movievisor.presentation.ui

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColor = darkColors(
    primary = PrimaryColor,
    background = Background,
    onBackground = ColorText,
    onPrimary = Background
)

@Composable
fun MovieAppTheme(darkTheme: Boolean = true, content: @Composable() () -> Unit) {
    MaterialTheme(
        colors = DarkColor,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}