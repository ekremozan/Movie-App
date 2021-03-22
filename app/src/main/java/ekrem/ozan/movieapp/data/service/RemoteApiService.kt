package ekrem.ozan.movieapp.data.service

import ekrem.ozan.movieapp.data.model.response.CastResponse
import ekrem.ozan.movieapp.data.model.response.MovieDetailReponse
import ekrem.ozan.movieapp.data.model.response.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface RemoteApiService {
    @GET("movie/popular")
    fun getPopularMovies(@Query("page") page: Int): Call<MovieResponse>

    @GET("trending/movie/day")
    fun getDailyTrendingMovies(): Call<MovieResponse>

    @GET("trending/movie/week")
    fun getWeeklyTrendingMovies(): Call<MovieResponse>

    @GET("movie/upcoming")
    fun getUpComingMovies(@Query("page") page: Int): Call<MovieResponse>

    @GET("movie/now_playing")
    fun getNowPlayingMovies(@Query("page") page: Int): Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetail(@Path("movie_id") movieId: Int): Call<MovieDetailReponse>

    @GET("movie/{movie_id}/similar")
    fun getSimilarMovies(@Path("movie_id") movieId: Int): Call<MovieResponse>

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(@Path("movie_id") movieId: Int): Call<CastResponse>

    @GET("movie/{movie_id}/recommendations")
    fun getRecommendationMovies(@Path("movie_id") movieId: Int): Call<MovieResponse>

    @GET("search/movie")
    fun searchMovie(@Query("query") query: String, @Query("page") page: Int): Call<MovieResponse>
}

