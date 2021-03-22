package ekrem.ozan.movieapp.presentation.movies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import ekrem.ozan.movieapp.base.viewmodel.BaseViewModel
import ekrem.ozan.movieapp.data.enum.MovieType.*
import ekrem.ozan.movieapp.domain.usecase.MovieListUseCase
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MoviesViewModel @Inject constructor(
    private val _useCaseMovieList: MovieListUseCase
) : BaseViewModel() {

    private val _liveDataViewState = MutableLiveData<MoviesFragmentViewState>()
    val livaDataViewState: LiveData<MoviesFragmentViewState> = _liveDataViewState

    fun getMovies() {
        updateUIState(showLoading = true)
        combine(
            _useCaseMovieList.getMovies(POPULAR),
            _useCaseMovieList.getMovies(UPCOMING),
            _useCaseMovieList.getMovies(WEEKLY_TRENDING),
            _useCaseMovieList.getMovies(DAILY_TRENDING),
            ::moviesItemCombiner
        )
            .onEach {
                _liveDataViewState.value = it
                updateUIState(showContent = true)
            }
            .launchIn(viewModelScope)
    }
}

