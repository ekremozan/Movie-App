package ekrem.ozan.movieapp.data.repository

import ekrem.ozan.movieapp.data.model.response.CastResponse
import ekrem.ozan.movieapp.data.model.response.MovieDetailReponse
import ekrem.ozan.movieapp.data.model.response.MovieResponse
import ekrem.ozan.movieapp.data.service.RemoteApiService
import ekrem.ozan.movieapp.domain.repository.IMovieRepository
import ekrem.ozan.movieapp.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(private val api: RemoteApiService) : IMovieRepository {
    override fun searchMovie(query: String, page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.searchMovie(query, page)
        emit(Response.Success(response))
    }

    override fun getNowPlayingMovies(page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getNowPlayingMovies(page)
        emit(Response.Success(response))
    }

    override fun getDailyTrendingMovies(page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getDailyTrendingMovies()
        emit(Response.Success(response))
    }

    override fun getWeeklyTrendingMovies(page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getWeeklyTrendingMovies()
        emit(Response.Success(response))
    }

    override fun getPopularMovies(page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getPopularMovies(page)
        emit(Response.Success(response))
    }

    override fun getUpComingMovies(page: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getUpComingMovies(page)
        emit(Response.Success(response))
    }

    override fun getSimilarMovies(movieId: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getSimilarMovies(movieId)
        emit(Response.Success(response))
    }

    override fun getRecommendationMovies(movieId: Int): Flow<Response<MovieResponse>> = flow {
        val response = api.getRecommendationMovies(movieId)
        emit(Response.Success(response))
    }

    override fun getMovieCredits(movieId: Int): Flow<Response<CastResponse>> = flow {
        val response = api.getMovieCredits(movieId)
        emit(Response.Success(response))
    }

    override fun getMovieDetail(movieId: Int): Flow<Response<MovieDetailReponse>> = flow {
        val response = api.getMovieDetail(movieId)
        emit(Response.Success(response))
    }
}