package ruangguru.id.tracking

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ruangguru.id.tracking.contracts.TrackContract
import ruangguru.id.tracking.helpers.APIHelper
import ruangguru.id.tracking.models.PostEvent
import ruangguru.id.tracking.services.EventService

/**
 * Created by rzgonz on 01/03/18.
 */
 class RgTrack{
    companion object :TrackContract.View {
       @SuppressLint("StaticFieldLeak")
       private lateinit var eventData:PostEvent
         override fun getService(): EventService {
            return APIHelper.getClient().create(EventService::class.java)
         }

       override fun postEvent(){
            // 2. Java object to JSON, and assign to a String
            Log.d("postEvent","--> ${eventData.toJson()}")
            getService().sendEvent(JsonParser().parse(eventData.toJson()).asJsonObject).enqueue(object : Callback<String>{
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
    }
}