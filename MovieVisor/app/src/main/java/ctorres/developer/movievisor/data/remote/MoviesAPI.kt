package ctorres.developer.movievisor.data.remote

import ctorres.developer.movievisor.data.remote.dto.MovieDetailDto
import ctorres.developer.movievisor.data.remote.dto.MoviesDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface MoviesAPI {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesDto

    @GET("movie/top_rated")
    suspend fun getRatedMovies(): MoviesDto

    @GET("movie/{movieId}")
    suspend fun getMovieDetail(@Path(value = "movieId") movieId: String): MovieDetailDto
}