package ruangguru.id.tracking.contracts

import android.content.Context
import ruangguru.id.tracking.RgTrack
import ruangguru.id.tracking.services.EventService

/**
 * Created by rzgonz on 01/03/18.
 */
object TrackContract {
    interface View{
        fun initTracker(context: Context)
        fun setBaseUrl(url: String)
        fun getService():EventService
        fun postEvent()
        fun isLogin(isLogin: Boolean): RgTrack.Companion
        fun setContext(context: String): RgTrack.Companion
        fun setEventType(eventType: String): RgTrack.Companion
        fun setEventVersion(eventVersion: Int): RgTrack.Companion
        fun setMemberID(memberID: String): RgTrack.Companion
        fun setSessionID(sessionID: String): RgTrack.Companion
        fun setCookiesID(cookiesID: String): RgTrack.Companion
        fun recreateCookiesID(): RgTrack.Companion
        fun hasCookies(): Boolean

    }

}