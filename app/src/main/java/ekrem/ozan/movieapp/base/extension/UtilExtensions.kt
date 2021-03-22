package ekrem.ozan.movieapp.base.extension

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import ekrem.ozan.movieapp.data.enum.ResponseState
import ekrem.ozan.movieapp.util.Response
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

fun String?.simpleDateConvert(newFormat: String): String? {
    if (this.isNullOrEmpty()) return ""
    val dateFormat = SimpleDateFormat("yyyy-dd-MM", Locale.ROOT)

    val myDate: Date?
    try {
        myDate = dateFormat.parse(this)
    } catch (e: ParseException) {
        return ""
    }

    val timeFormat = SimpleDateFormat(newFormat, Locale.ROOT)
    return timeFormat.format(myDate ?: Date())
}

inline fun <T> LiveData<T>.observeNonNull(
    owner: LifecycleOwner,
    crossinline observer: (t: T) -> Unit
) {
    this.observe(owner, androidx.lifecycle.Observer {
        it?.let(observer)
    })
}

@Suppress("UNCHECKED_CAST")
fun <T> Response<T>.getData(): T? {
    return when (this) {
        is Response.Success<*> -> this.data as T?
        else -> null
    }
}

fun <V, T> Response<V>.getState(response: T): ResponseState {
    return when (response) {
        is Response.Loading -> ResponseState.LOADING
        is Response.Success<*> -> ResponseState.SUCCESS
        is Response.Error -> ResponseState.ERROR
        is Response.Empty -> ResponseState.EMPTY
        else -> ResponseState.NONE
    }
}