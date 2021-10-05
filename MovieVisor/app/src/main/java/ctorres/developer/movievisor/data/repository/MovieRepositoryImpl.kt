package ctorres.developer.movievisor.data.repository

import ctorres.developer.movievisor.data.remote.MoviesAPI
import ctorres.developer.movievisor.data.remote.dto.MovieDetailDto
import ctorres.developer.movievisor.data.remote.dto.MoviesDto
import ctorres.developer.movievisor.domain.repository.MovieRepository
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val api: MoviesAPI): MovieRepository {
    override suspend fun getPopularMovies(): MoviesDto {
        return api.getPopularMovies()
    }

    override suspend fun getRatedMovies(): MoviesDto {
        return api.getRatedMovies()
    }

    override suspend fun getMovieDetail(movieId: String): MovieDetailDto {
        return api.getMovieDetail(movieId)
    }
}