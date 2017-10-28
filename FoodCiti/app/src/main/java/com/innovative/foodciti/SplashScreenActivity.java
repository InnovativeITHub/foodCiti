package com.innovative.foodciti;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import com.innovative.foodciti.authentication.LoginActivity;
import com.innovative.foodciti.firebaseServices.AndroidFirebaseInstanceIdService;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int SPLASH_TIME_OUT= 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        startService(new Intent(SplashScreenActivity.this, AndroidFirebaseInstanceIdService.class));

        init();
    }

    private void init() {

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start your app main activity

                Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }


}
