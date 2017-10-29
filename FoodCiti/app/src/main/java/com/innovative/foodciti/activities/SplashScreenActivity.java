package com.innovative.foodciti.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.innovative.foodciti.R;
import com.innovative.foodciti.models.OrderSummary;
import com.innovative.foodciti.utils.SharedPrefernceValue;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int SPLASH_TIME_OUT = 3000;

    private boolean isLoggedIn;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        //startService(new Intent(SplashScreenActivity.this, AndroidFirebaseInstanceIdService.class));
        init();
    }

    private void init() {

        sharedPreferences = getSharedPreferences(SharedPrefernceValue.MyPREFERENCES, Context.MODE_PRIVATE);
        isLoggedIn = Boolean.parseBoolean(sharedPreferences.getString(SharedPrefernceValue.IS_LOGGED_IN, ""));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if (isLoggedIn) {

                    Intent intent = new Intent(SplashScreenActivity.this, OrderSummaryActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                    finish();
                } else {

                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    overridePendingTransition(R.anim.left_to_right, R.anim.right_to_left);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    public void onBackPressed() {

    }

}
