package ekrem.ozan.movieapp.data.model.response

import com.google.gson.annotations.SerializedName
import ekrem.ozan.movieapp.data.model.Movie

class MovieResponse(
    @SerializedName("page") val page: Int?,
    @SerializedName("total_pages") val totalPages: Int?,
    @SerializedName("results") val results: ArrayList<Movie>?
)