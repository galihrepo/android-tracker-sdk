package id.ruangguru

import android.support.v4.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ruangguru.id.tracking.RgTrack
import java.util.*

/**
 * A placeholder fragment containing a simple view.
 */
class Main3ActivityFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        RgTrack.setEventType(" Fragment ${UUID.randomUUID()}").postEvent()
        return inflater.inflate(R.layout.fragment_main3, container, false)
    }
}
