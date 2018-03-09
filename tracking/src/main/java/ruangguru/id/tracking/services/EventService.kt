package ruangguru.id.tracking.services

import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by rzgonz on 01/03/18.
 */
interface EventService {
    @Headers("Content-Type: application/json")
    @POST("api/v1/event/tracker")
    fun sendEvent(@Body body: JsonObject): Call<String>

}