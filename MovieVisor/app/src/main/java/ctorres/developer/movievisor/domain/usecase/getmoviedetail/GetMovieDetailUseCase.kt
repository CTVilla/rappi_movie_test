package ctorres.developer.movievisor.domain.usecase.getmoviedetail

import ctorres.developer.movievisor.common.Resource
import ctorres.developer.movievisor.data.remote.dto.toMovieDetail
import ctorres.developer.movievisor.data.repository.MovieRepositoryImpl
import ctorres.developer.movievisor.domain.model.MovieDetail
import ctorres.developer.movievisor.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(
    private val  repository: MovieRepository
) {

    operator fun invoke(movieId: String): Flow<Resource<MovieDetail>> = flow {
        try {
            emit(Resource.onLoading<MovieDetail>())
            val movieDetail = repository.getMovieDetail(movieId).toMovieDetail()
            emit(Resource.onSuccess<MovieDetail>(movieDetail))
        } catch (httpException: HttpException) {
            emit(Resource.onError<MovieDetail>(httpException.localizedMessage?:"Network error"))
        } catch (ioException: IOException) {
            emit(Resource.onError<MovieDetail>(ioException.localizedMessage?:"IO error"))
        }
    }
}