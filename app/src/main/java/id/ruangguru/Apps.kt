package id.ruangguru

import android.app.Application
import ruangguru.id.tracking.RgTrack
import java.util.*

/**
 * Created by rzgonz on 01/03/18.
 */
class Apps : Application() {

    override fun onCreate() {
        super.onCreate()
        RgTrack.setBaseUrl("http://application-tracking-api-dot-silicon-airlock-153323.appspot.com/")
        RgTrack.initTracker(baseContext)
        if(!RgTrack.hasCookies()){
            RgTrack.recreateCookiesID()
        }
    }

}