package ekrem.ozan.movieapp.data.service

import ekrem.ozan.movieapp.data.model.response.MovieResponse
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query

interface RemoteApiService {
    @GET("search/movie")
    fun searchMovieAsync(
        @Query("query") query: String,
        @Query("page") page: Int
    ): Deferred<MovieResponse>
}

