package ctorres.developer.movievisor.presentation.movielist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ctorres.developer.movievisor.common.Resource
import ctorres.developer.movievisor.domain.usecase.getmovies.GetPopularMoviesUseCase
import ctorres.developer.movievisor.domain.usecase.getmovies.GetRatedMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RatedMovieListViewModel @Inject constructor(
    private val getPopularMoviesUseCase: GetPopularMoviesUseCase,
    private val getRatedMoviesUseCase: GetRatedMoviesUseCase): ViewModel() {
    private val _state = mutableStateOf(MovieListState())
    val state: State<MovieListState> = _state

    init {
        getRatedMoviesList()
    }

    private fun getRatedMoviesList(){
        getRatedMoviesUseCase().onEach { result->
            when(result) {
                is Resource.onLoading ->{
                    _state.value = MovieListState(isLoading = true)
                }
                is Resource.onSuccess ->{
                    _state.value = MovieListState(movies = result.data?: emptyList())
                }
                is Resource.onError ->{
                    _state.value = MovieListState(error = result.msg?:"error")
                }
            }
        }.launchIn(viewModelScope)
    }
}