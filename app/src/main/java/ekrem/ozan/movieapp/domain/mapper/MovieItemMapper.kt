package ekrem.ozan.movieapp.domain.mapper

import ekrem.ozan.movieapp.base.extension.orZero
import ekrem.ozan.movieapp.data.model.response.MovieResponse
import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem
import ekrem.ozan.movieapp.data.model.uimodel.MovieViewItem
import ekrem.ozan.movieapp.domain.decider.MovieItemDecider
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieItemMapper @Inject constructor(private val itemDecider: MovieItemDecider) : Mapper<MovieResponse, MovieListViewItem> {
    override fun mapFrom(item: MovieResponse): MovieListViewItem {
        return MovieListViewItem(
            page = item.page.orZero(),
            totalPage = item.totalPages.orZero(),
            movies = item.results?.map { movie ->
                MovieViewItem(
                    id = movie.id.orZero(),
                    imagePath = itemDecider.provideImagePath(movie.posterPath).orEmpty(),
                    title = movie.title.orEmpty()
                )
            }.orEmpty()
        )
    }
}