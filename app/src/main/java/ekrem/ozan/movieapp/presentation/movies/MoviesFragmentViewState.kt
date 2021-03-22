package ekrem.ozan.movieapp.presentation.movies

import ekrem.ozan.movieapp.base.extension.getData
import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem
import ekrem.ozan.movieapp.util.Response

class MoviesFragmentViewState(
    private val popularMovies: Response<MovieListViewItem>,
    private val upcomingMovies: Response<MovieListViewItem>,
    private val weeklyTrendingMovies: Response<MovieListViewItem>,
    private val dailyTrendingMovies: Response<MovieListViewItem>
) {
    fun getPopularMovies(): MovieListViewItem? = popularMovies.getData()
    fun getUpComingMovies(): MovieListViewItem? = upcomingMovies.getData()
    fun getWeeklyTrendingMovies(): MovieListViewItem? = weeklyTrendingMovies.getData()
    fun getDailyTrendingMovies(): MovieListViewItem? = dailyTrendingMovies.getData()
    fun getPopularMoviesTitle(): String = "Popular"
    fun getUpcomingMoviesTitle(): String = "Upcoming"
    fun getWeeklyTrendingMoviesTitle(): String = "Weekly Trending"
    fun getDailyTrendingMoviesTitle(): String = "Daily Trending"
}