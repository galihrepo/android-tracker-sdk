package ruangguru.id.tracking

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.gson.JsonParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ruangguru.id.tracking.contracts.TrackContract
import ruangguru.id.tracking.helpers.APIHelper
import ruangguru.id.tracking.helpers.SharedPreferenceService
import ruangguru.id.tracking.models.PostEvent
import ruangguru.id.tracking.services.EventService
import java.util.*

/**
 * Created by rzgonz on 01/03/18.
 */
 open class RgTrack{
    companion object :TrackContract.View {
       @SuppressLint("StaticFieldLeak")
       private lateinit var eventData:PostEvent
         override fun getService(): EventService {
            return APIHelper.getClient().create(EventService::class.java)
         }

       override fun postEvent(){
            // 2. Java object to JSON, and assign to a String
            Log.d("postEventodl ","--> ${eventData.toJson()}")
           val json = PostEvent(eventData.c).copyData(eventData)
           eventData.eventType = ""
           eventData.context   = ""
           Log.d("postEvent","--> ${json}")
            getService().sendEvent(JsonParser().parse(json).asJsonObject).enqueue(object : Callback<String>{
                override fun onFailure(call: Call<String>?, t: Throwable?) {
                    Log.d("gagal", t.toString())
                }
                override fun onResponse(call: Call<String>?, response: Response<String>?) {
                    Log.d("berhasil",response.toString())
                }
            })
        }

         override fun setBaseUrl(url:String){
            APIHelper.BASE_URL = url
        }

        override fun initTracker(context: Context) {
            eventData = PostEvent(context)
        }

        override fun isLogin(isLogin: Boolean): Companion {
           eventData.isLogged = isLogin
            return this
        }

        override fun setContext(context: String): Companion {
           eventData.context = context
            return this
        }

        override fun setEventType(eventType: String): Companion {
           eventData.eventType = eventType
            return this
        }

        override fun setEventVersion(eventVersion: Int): Companion {
            eventData.eventVersion = eventVersion
            return this
        }

        override fun setMemberID(memberID: String): Companion {
            eventData.memberId = memberID
            return this
        }

        override fun setSessionID(sessionID: String): Companion {
            eventData.sessionId = sessionID
            return this
        }

        override fun setCookiesID(cookiesID: String): Companion {
            eventData.cookiesId = cookiesID
            return this
        }

        override fun recreateCookiesID(): Companion {
            SharedPreferenceService(eventData.c).saveString("cookiesID",UUID.randomUUID().toString())
            Log.d("recreateCookiesID" , UUID.randomUUID().toString() )
            return this
        }

        override fun hasCookies(): Boolean {
            return SharedPreferenceService(eventData.c).getString("cookiesID","").isNotEmpty()
        }
    }
}