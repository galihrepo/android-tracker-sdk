package id.ruangguru

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.gson.Gson
import ruangguru.id.tracking.RgTrack
import ruangguru.id.tracking.models.PostEvent

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RgTrack.postEvent()
        startActivity(Intent(baseContext,Main2Activity::class.java))
    }
}