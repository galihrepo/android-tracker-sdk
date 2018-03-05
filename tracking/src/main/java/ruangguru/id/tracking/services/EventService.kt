package ruangguru.id.tracking.services

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

/**
 * Created by rzgonz on 01/03/18.
 */
interface EventService {
    @Headers("Content-Type: application/json")
    @POST("api/v1/event/tracker")
    fun sendEvent(@Body body:String): Call<String>

}