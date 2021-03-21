package ekrem.ozan.movieapp.domain.repository

import ekrem.ozan.movieapp.data.model.response.CastResponse
import ekrem.ozan.movieapp.data.model.response.MovieDetailReponse
import ekrem.ozan.movieapp.data.model.response.MovieResponse
import ekrem.ozan.movieapp.util.Response
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    fun searchMovie(query: String, page: Int): Flow<Response<MovieResponse>>
    fun getNowPlayingMovies(page: Int): Flow<Response<MovieResponse>>
    fun getDailyTrendingMovies(page: Int): Flow<Response<MovieResponse>>
    fun getWeeklyTrendingMovies(page: Int): Flow<Response<MovieResponse>>
    fun getPopularMovies(page: Int): Flow<Response<MovieResponse>>
    fun getUpComingMovies(page: Int): Flow<Response<MovieResponse>>
    fun getSimilarMovies(movieId: Int): Flow<Response<MovieResponse>>
    fun getRecommendationMovies(movieId: Int): Flow<Response<MovieResponse>>
    fun getMovieCredits(movieId: Int): Flow<Response<CastResponse>>
    fun getMovieDetail(movieId: Int): Flow<Response<MovieDetailReponse>>
}