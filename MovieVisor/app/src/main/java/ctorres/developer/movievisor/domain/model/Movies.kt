package ctorres.developer.movievisor.domain.model

data class Movies (
    val page: Int,
    val movies: List<Movie>,
    val totalPages: Int,
    val totalResults: Int
)