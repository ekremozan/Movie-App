package ekrem.ozan.movieapp.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ekrem.ozan.movieapp.base.extension.getData
import ekrem.ozan.movieapp.base.viewmodel.BaseViewModel
import ekrem.ozan.movieapp.data.model.uimodel.MovieListViewItem
import ekrem.ozan.movieapp.domain.usecase.SearchMovieUseCase
import javax.inject.Inject

class SearchMovieViewModel @Inject constructor(
    private val searchMovieUseCase: SearchMovieUseCase
) : BaseViewModel() {

    private val _liveDataSearchMovie = MutableLiveData<MovieListViewItem>()
    val liveDataSearchMovie: LiveData<MovieListViewItem> = _liveDataSearchMovie

    suspend fun searchMovie(searchText: String, page: Int) {
        searchMovieUseCase.searchMovie(searchText, page).sendRequest { movieListViewItem ->
            _liveDataSearchMovie.postValue(movieListViewItem.getData())
        }
    }
}