package ekrem.ozan.movieapp.domain.usecase

import ekrem.ozan.movieapp.data.enum.MovieType
import ekrem.ozan.movieapp.data.enum.MovieType.*
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
class MovieListUseCase @Inject constructor(
    private val repository: RemoteRepository,
    private val itemMapper: MovieItemMapper
) {
    fun getMovies(movieType: MovieType, page: Int = 1, movieId: Int = 0): Flow<Response<MovieListViewItem>> {
        return when (movieType) {
            NOW_PLAYING -> repository.getNowPlayingMovies(page).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            POPULAR -> repository.getPopularMovies(page).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            RECOMMENDATION -> repository.getRecommendationMovies(movieId).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            SIMILAR -> repository.getSimilarMovies(movieId).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            UPCOMING -> repository.getUpComingMovies(page).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            DAILY_TRENDING -> repository.getDailyTrendingMovies(page).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
            WEEKLY_TRENDING -> repository.getWeeklyTrendingMovies(page).map { response ->
                response.map { result -> itemMapper.mapFrom(result) }
            }
        }
    }
}