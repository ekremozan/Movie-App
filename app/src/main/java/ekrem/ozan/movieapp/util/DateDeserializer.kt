package ekrem.ozan.movieapp.util

import android.util.Log
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class DateDeserializer : JsonDeserializer<Date?> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        element: JsonElement,
        arg1: Type,
        arg2: JsonDeserializationContext
    ): Date? {
        val date = element.asString
        val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssz", Locale.ROOT)
        formatter.timeZone = TimeZone.getTimeZone("UTC")
        return try {
            formatter.parse(date)
        } catch (e: ParseException) {
            Log.e("Failed", e.message!!)
            null
        }
    }
}