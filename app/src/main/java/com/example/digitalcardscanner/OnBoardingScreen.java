package com.example.digitalcardscanner;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class OnBoardingScreen extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;
    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    TextView slider_heading,slider_desc;
    Animation animation;
    int currentPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding_screen);

        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted = findViewById(R.id.get_started_btn);
        slider_heading = findViewById(R.id.slider_heading);
        slider_desc = findViewById(R.id.slider_desc);

        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        letsGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(OnBoardingScreen.this,PatternActivity.class);
                startActivity(intent);
            }
        });

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view) {
        startActivity(new Intent(this, PatternActivity.class));
        finish();
    }

    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }

    private void addDots(int position) {

        dots = new TextView[8];
        dotsLayout.removeAllViews();

        for (int i = 0; i < dots.length; i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("•"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if (dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPos = position;

            if (position == 0) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.first_slide_title);
                slider_desc.setText(R.string.first_slide_desc);
            } else if (position == 1) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.second_slide_title);
                slider_desc.setText(R.string.second_slide_desc);
            } else if (position == 2) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.third_slide_title);
                slider_desc.setText(R.string.third_slide_desc);
            } else if (position == 3) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.fourth_slide_title);
                slider_desc.setText(R.string.fourth_slide_desc);

            } else if (position == 4) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.fifth_slide_title);
                slider_desc.setText(R.string.fifth_slide_desc);
            } else if (position == 5) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.sixth_slide_title);
                slider_desc.setText(R.string.sixth_slide_desc);
            } else if (position == 6) {
                letsGetStarted.setVisibility(View.INVISIBLE);
                slider_heading.setText(R.string.seventh_slide_title);
                slider_desc.setText(R.string.seventh_slide_desc);
            } else {
                animation = AnimationUtils.loadAnimation(OnBoardingScreen.this, R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
                slider_heading.setText(R.string.eight_slide_title);
                slider_desc.setText(R.string.eight_slide_desc);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}