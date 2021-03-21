package ekrem.ozan.movieapp.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ekrem.ozan.movieapp.presentation.detail.MovieDetailFragment
import ekrem.ozan.movieapp.presentation.list.MovieListFragment
import ekrem.ozan.movieapp.presentation.movies.MoviesFragment
import ekrem.ozan.movieapp.presentation.search.SearchMovieFragment

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeSplashFragment(): MoviesFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchMovieFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieDetailFragment(): MovieDetailFragment

    @ContributesAndroidInjector
    abstract fun contributeMovieListFragment(): MovieListFragment
}
