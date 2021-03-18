package ekrem.ozan.movieapp.domain.repository

import ekrem.ozan.movieapp.data.model.response.MovieResponse
import kotlinx.coroutines.Deferred

interface IMovieRepository {
    fun searchMovieAsync(query: String, page: Int): Deferred<MovieResponse>
}