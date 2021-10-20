package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.Objects;

public class SplashActivity extends AppCompatActivity {

    ImageView appname,layout,welcome;
    LottieAnimationView lottieAnimationView;
    SharedPreferences onBoardingScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        layout=findViewById(R.id.cons_layout);
        welcome=findViewById(R.id.welcome);
        appname = findViewById(R.id.app_name);
        lottieAnimationView = findViewById(R.id.splash_view);
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        layout.animate().translationY(-2500).setDuration(1000).setStartDelay(5000);
        appname.animate().translationX(-2000).setDuration(1000).setStartDelay(5000);
        welcome.animate().translationX(2000).setDuration(1000).setStartDelay(5000);
        lottieAnimationView.animate().translationY(1500).setDuration(1000).setStartDelay(5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                onBoardingScreen = getSharedPreferences("onBoardingScreen",MODE_PRIVATE);
                boolean isFirsTime = onBoardingScreen.getBoolean("firstTime",true);
                if (isFirsTime){
                    SharedPreferences.Editor editor = onBoardingScreen.edit();
                    editor.putBoolean("firstTime",false);
                    editor.commit();
                    startActivity(new Intent(SplashActivity.this,OnBoardingScreen.class));
                    finish();
                }
                else
                {
                    startActivity(new Intent(SplashActivity.this,PatternActivity.class));
                    finish();
                }

            }
        },6000);
    }
}