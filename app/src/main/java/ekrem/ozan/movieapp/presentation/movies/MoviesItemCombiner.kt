package ekrem.ozan.movieapp.presentation.movies

import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem
import ekrem.ozan.movieapp.util.Response

fun moviesItemCombiner(
    popularMovies: Response<MovieListViewItem>,
    upcomingMovies: Response<MovieListViewItem>,
    weeklyTrendingMovies: Response<MovieListViewItem>,
    dailyTrendingMovies: Response<MovieListViewItem>
): MoviesFragmentViewState = MoviesFragmentViewState(popularMovies, upcomingMovies, weeklyTrendingMovies, dailyTrendingMovies)

