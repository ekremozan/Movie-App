package ekrem.ozan.movieapp.domain.usecase

import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem
import ekrem.ozan.movieapp.data.repository.RemoteRepository
import ekrem.ozan.movieapp.domain.mapper.MovieItemMapper
import ekrem.ozan.movieapp.util.Response
import ekrem.ozan.movieapp.util.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMovieUseCase @Inject constructor(
    private val repository: RemoteRepository,
    private val itemMapper: MovieItemMapper
) {
    fun searchMovie(searchText: String, page: Int): Flow<Response<MovieListViewItem>> {
        return repository.searchMovie(searchText, page).map { item ->
            item.map { result -> itemMapper.mapFrom(result) }
        }
    }
}