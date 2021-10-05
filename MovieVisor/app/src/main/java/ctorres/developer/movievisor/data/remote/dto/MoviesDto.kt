package ctorres.developer.movievisor.data.remote.dto


import com.google.gson.annotations.SerializedName
import ctorres.developer.movievisor.domain.model.Movies

data class MoviesDto(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val movies: List<MovieDto>,
    @SerializedName("total_pages")
    val totalPages: Int,
    @SerializedName("total_results")
    val totalResults: Int
)

fun MoviesDto.toMovies(): Movies {
    return Movies(page = page, movies = movies.map { it.toMovie() }, totalPages = totalPages, totalResults = totalResults)
}
