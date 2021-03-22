package ekrem.ozan.movieapp.domain.decider

import ekrem.ozan.movieapp.util.Constants
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieItemDecider @Inject constructor() {
    fun provideImagePath(path: String?): String? = "${Constants.POSTER_PATH}$path"
}