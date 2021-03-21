package ekrem.ozan.movieapp.base.viewmodel

import android.os.Bundle
import androidx.lifecycle.ViewModel
import ekrem.ozan.movieapp.base.domain.BaseViewViewState
import ekrem.ozan.movieapp.util.SingleLiveEvent
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach

abstract class BaseViewModel(
    val baseViewViewStateLiveData: SingleLiveEvent<BaseViewViewState> = SingleLiveEvent()
) : ViewModel() {
    open fun handleIntent(extras: Bundle) {}

    fun updateUIState(
        showLoading: Boolean = false,
        showContent: Boolean = false,
        showError: Boolean = false,
        showEmpty: Boolean = false,
        throwable: Throwable? = null
    ) {
        baseViewViewStateLiveData.value =
            BaseViewViewState(showLoading, showContent, showError, showEmpty, throwable)
    }

    suspend inline fun <T> Flow<T>.sendRequest(crossinline onComplete: (T) -> Unit) {
        onEach { data -> onComplete(data) }.collect()
    }
}