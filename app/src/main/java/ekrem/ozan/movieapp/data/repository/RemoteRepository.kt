package ekrem.ozan.stackoverflowapi.data.repository

import ekrem.ozan.movieapp.data.model.response.MovieResponse
import ekrem.ozan.movieapp.data.service.RemoteApiService
import ekrem.ozan.movieapp.domain.repository.IMovieRepository
import kotlinx.coroutines.Deferred
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteRepository @Inject constructor(private val api: RemoteApiService) : IMovieRepository {
    override fun searchMovieAsync(query: String, page: Int): Deferred<MovieResponse> =
        api.searchMovieAsync(query, page)
}