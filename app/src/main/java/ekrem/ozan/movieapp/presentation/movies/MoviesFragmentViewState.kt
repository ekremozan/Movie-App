package ekrem.ozan.movieapp.presentation.movies

import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem

class MoviesFragmentViewState(
    private val popularMovies: MovieListViewItem,
    private val upcomingMovies: MovieListViewItem,
    private val weeklyTrendingMovies: MovieListViewItem,
    private val dailyTrendingMovies: MovieListViewItem
) {
    fun getPopularMovies(): MovieListViewItem = popularMovies
    fun getUpComingMovies(): MovieListViewItem = upcomingMovies
    fun getWeeklyTrendingMovies(): MovieListViewItem = weeklyTrendingMovies
    fun getDailyTrendingMovies(): MovieListViewItem = dailyTrendingMovies
    fun getPopularMoviesTitle(): String = "Popular"
    fun getUpcomingMoviesTitle(): String = "Upcoming"
    fun getWeeklyTrendingMoviesTitle(): String = "Weekly Trending"
    fun getDailyTrendingMoviesTitle(): String = "Daily Trending"
}