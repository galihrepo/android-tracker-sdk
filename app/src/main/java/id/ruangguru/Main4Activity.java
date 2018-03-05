package id.ruangguru;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ruangguru.id.tracking.RgTrack;

public class Main4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        RgTrack.Companion.setEventType("Java model pos").postEvent();
    }
}
