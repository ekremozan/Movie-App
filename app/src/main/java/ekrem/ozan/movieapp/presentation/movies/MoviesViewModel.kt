package ekrem.ozan.movieapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ekrem.ozan.movieapp.base.viewmodel.BaseViewModel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(

) : BaseViewModel() {

    private val _liveDataViewState = MutableLiveData<MoviesFragmentViewState>()
    val livaDataViewState: LiveData<MoviesFragmentViewState> = _liveDataViewState

    suspend fun getMovies() {

    }
}

