package com.aplikasi.eBudgeting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen2 extends AppCompatActivity {

    private int SPLASH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen2);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                //setelah loading maka akan langsung berpindah ke home activity
                Intent menu =new Intent(SplashScreen2.this, SplashScreenActivity.class);
                startActivity(menu);
                finish();

            }
        },SPLASH);
    }
}
