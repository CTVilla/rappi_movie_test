package ctorres.developer.movievisor.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ctorres.developer.movievisor.presentation.movielist.components.PopularMovieListScreen
import ctorres.developer.movievisor.presentation.ui.MovieAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovieAppTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoute.MovieListScreen.route
                    ) {
                        composable(
                            route = ScreenRoute.MovieListScreen.route
                        ){
                            PopularMovieListScreen(navController)
                        }
//                        composable(
//                            route = ScreenRoute.MovieListScreen.route
//                        ){
//                            MovieDetailScreen()
//                        }

                    }
                }
            }
        }
    }
}