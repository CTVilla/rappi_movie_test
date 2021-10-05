package ctorres.developer.movievisor.presentation.moviedetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import ctorres.developer.movievisor.common.Constants
import ctorres.developer.movievisor.common.Resource
import ctorres.developer.movievisor.domain.usecase.getmoviedetail.GetMovieDetailUseCase
import ctorres.developer.movievisor.domain.usecase.getmovies.GetPopularMoviesUseCase
import ctorres.developer.movievisor.domain.usecase.getmovies.GetRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val getMovieDetailUseCase: GetMovieDetailUseCase,
    savedStateHandle: SavedStateHandle): ViewModel() {

    private val _state = mutableStateOf(MovieDetailState())
    val state: State<MovieDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_MOVIE_ID)?.let { movieId->
            getMovieDetail(movieId)
        }
    }

    private fun getMovieDetail(movieId: String){
        getMovieDetailUseCase(movieId).onEach { result->
            when(result) {
                is Resource.onLoading ->{
                    _state.value = MovieDetailState(isLoading = true)
                }
                is Resource.onSuccess ->{
                    _state.value = MovieDetailState(movieDetail = result.data)
                }
                is Resource.onError ->{
                    _state.value = MovieDetailState(error = result.msg?:"error")
                }
            }
        }
    }
}