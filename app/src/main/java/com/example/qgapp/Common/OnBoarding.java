package com.example.qgapp.Common;

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

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.qgapp.ActivityDestroy;
import com.example.qgapp.HelperClasses.SliderAdapter;
import com.example.qgapp.R;
import com.example.qgapp.login.LoginActivity;

public class OnBoarding extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;
    Button letsGetStarted;
    Animation animation;
    Button Skip;
    int currentPos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDestroy.addDestroyActivityToMap(this,"MainActivity");
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_on_boarding);

        //Hooks
        viewPager = findViewById(R.id.on_boarding_slider);
        dotsLayout = findViewById(R.id.on_boarding_dots);
        letsGetStarted = findViewById(R.id.on_boarding_button_started);

        //Call adapter
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);

        //Dots
        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);

        //Button: Skip
        Skip = findViewById(R.id.on_boarding_button_skip);
        Skip.bringToFront();
        Skip.setOnClickListener(view -> {
            System.out.println(123);
            skip();
        });
    }

    //点击跳过跳转活动
    public void skip() {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    //点击下一个页数加一
    public void next(View view) {
        viewPager.setCurrentItem(currentPos + 1);
    }

    //页面左下角添加计数功能
    private void addDots(int position) {

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length;i++) {
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8226;"));
            dots[i].setTextSize(35);

            dotsLayout.addView(dots[i]);
        }

        if(dots.length > 0) {
            dots[position].setTextColor(getResources().getColor(R.color.black));
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

            if(position == 0) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else if(position == 1) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else if(position == 2) {
                letsGetStarted.setVisibility(View.INVISIBLE);
            }
            else {//最后一页显示start，滑动进入
                animation = AnimationUtils.loadAnimation(OnBoarding.this, R.anim.bottom_anim);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
                letsGetStarted.bringToFront();
                letsGetStarted.setOnClickListener(view -> {
                    skip();
                });
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

}