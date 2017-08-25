package com.medfinder.drugsearch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by pelum on 8/25/2017.
 */

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        // setting a splash screen
        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(Splash.this, MainActivity.class));
                finish();
            }
        }, secondsDelayed * 2000);

    }
}
