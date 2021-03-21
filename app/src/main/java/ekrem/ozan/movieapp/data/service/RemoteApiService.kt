package ekrem.ozan.movieapp.data.service

import ekrem.ozan.movieapp.data.model.response.CastResponse
import ekrem.ozan.movieapp.data.model.response.MovieDetailReponse
import ekrem.ozan.movieapp.data.model.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RemoteApiService {
    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int): MovieResponse

    @GET("trending/movie/day")
    fun getDailyTrendingMovies(): MovieResponse

    @GET("trending/movie/week")
    fun getWeeklyTrendingMovies(): MovieResponse

    @GET("movie/upcoming")
    fun getUpComingMovies(@Query("page") page: Int): MovieResponse

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("page") page: Int): MovieResponse

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): MovieDetailReponse

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") movieId: Int): MovieResponse

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(@Path("movie_id") movieId: Int): CastResponse

    @GET("movie/{movie_id}/recommendations")
    fun getRecommendationMovies(@Path("movie_id") movieId: Int): MovieResponse

    @GET("search/movie")
    fun searchMovie(@Query("query") query: String, @Query("page") page: Int): MovieResponse
}

