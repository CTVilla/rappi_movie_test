package ctorres.developer.movievisor.domain.repository

import ctorres.developer.movievisor.data.remote.dto.MovieDetailDto
import ctorres.developer.movievisor.data.remote.dto.MoviesDto

interface MovieRepository {

    suspend fun getPopularMovies(): MoviesDto

    suspend fun getRatedMovies(): MoviesDto

    suspend fun getMovieDetail(movieId: String): MovieDetailDto
}