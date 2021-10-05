package ctorres.developer.movievisor.presentation.moviedetail

import ctorres.developer.movievisor.domain.model.Movie
import ctorres.developer.movievisor.domain.model.MovieDetail

data class MovieDetailState(
    val isLoading: Boolean = false,
    val movieDetail: MovieDetail? = null,
    val error: String = ""
)
