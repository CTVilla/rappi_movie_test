package ctorres.developer.movievisor.presentation

sealed class ScreenRoute(val route: String) {
    object MovieListScreen: ScreenRoute("movie_list_screen")
    object MovieDetailScreen: ScreenRoute("movie_detail_screen")
}
