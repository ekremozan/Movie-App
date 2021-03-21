package ekrem.ozan.movieapp.presentation.movies

import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem

class MoviesItemCombiner : (MovieListViewItem, MovieListViewItem, MovieListViewItem, MovieListViewItem) -> MoviesFragmentViewState {
    override fun invoke(p1: MovieListViewItem, p2: MovieListViewItem, p3: MovieListViewItem, p4: MovieListViewItem): MoviesFragmentViewState {
        return MoviesFragmentViewState(popularMovies = p1, upcomingMovies = p2, weeklyTrendingMovies = p3, dailyTrendingMovies = p4)
    }
}
