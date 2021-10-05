package ctorres.developer.movievisor.presentation.movielist

import ctorres.developer.movievisor.domain.model.Movie

data class MovieListState(
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: String = ""
)
