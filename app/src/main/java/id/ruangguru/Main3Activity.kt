package id.ruangguru

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log

import kotlinx.android.synthetic.main.activity_main3.*
import ruangguru.id.tracking.RgTrack
import java.util.*

class Main3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            RgTrack.setEventType(" Main3Activity ${UUID.randomUUID()}").postEvent()
           // startActivity(Intent(baseContext,Main4Activity::class.java))
        }
    }

}
