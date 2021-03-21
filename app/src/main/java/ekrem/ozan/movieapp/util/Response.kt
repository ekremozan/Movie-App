package ekrem.ozan.movieapp.util

sealed class Response<out T> {
    class Success<T>(val data: T) : Response<T>()
    class Error(val exception: Throwable) : Response<Nothing>()
    object Loading : Response<Nothing>()
    object Empty : Response<Nothing>()
}

inline fun <T, R> Response<T>.map(transform: (T) -> R): Response<R> {
    return when (this) {
        is Response.Success -> Response.Success(transform(data))
        is Response.Error -> Response.Error(exception)
        is Response.Loading -> Response.Loading
        is Response.Empty -> Response.Empty
    }
}