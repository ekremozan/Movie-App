package ekrem.ozan.movieapp.data.model.response

import com.google.gson.annotations.SerializedName
import ekrem.ozan.movieapp.data.model.Cast

data class CastResponse(
    @SerializedName("cast") val cast: List<Cast>?,
    @SerializedName("id") val id: Int?
)