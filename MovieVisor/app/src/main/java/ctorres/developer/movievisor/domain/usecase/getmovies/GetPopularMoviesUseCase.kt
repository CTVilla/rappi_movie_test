package ctorres.developer.movievisor.domain.usecase.getmovies

import ctorres.developer.movievisor.common.Resource
import ctorres.developer.movievisor.data.remote.dto.toMovie
import ctorres.developer.movievisor.data.repository.MovieRepositoryImpl
import ctorres.developer.movievisor.domain.model.Movie
import ctorres.developer.movievisor.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(
    private val  repository: MovieRepository
) {

    operator fun invoke(): Flow<Resource<List<Movie>>> = flow {
        try {
            emit(Resource.onLoading<List<Movie>>())
            val movies = repository.getPopularMovies().movies.map { it.toMovie() }
            emit(Resource.onSuccess(movies))
        } catch (httpException: HttpException) {
            emit(Resource.onError<List<Movie>>(httpException.localizedMessage?:"Network error"))
        } catch (ioException: IOException) {
            emit(Resource.onError<List<Movie>>(ioException.localizedMessage?:"IO error"))
        }
    }
}