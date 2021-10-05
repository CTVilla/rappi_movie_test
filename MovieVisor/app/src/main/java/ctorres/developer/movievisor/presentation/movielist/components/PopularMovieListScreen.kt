package ctorres.developer.movievisor.presentation.movielist.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import ctorres.developer.movievisor.presentation.ScreenRoute
import ctorres.developer.movievisor.presentation.movielist.PopularMovieListViewModel


@Composable
fun PopularMovieListScreen(navController: NavController,
                    popularViewModel:PopularMovieListViewModel = hiltViewModel()
) {
    val state = popularViewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        LazyColumn(modifier = Modifier.fillMaxSize()){
            items(state.movies) { movie->
                MovieListItem(movie = movie,
                    onItemClick = {
                        navController.navigate(ScreenRoute.MovieDetailScreen.route)
                    })
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
                    .align(Alignment.Center),
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
            )
        }
        if(state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}