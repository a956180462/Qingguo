package com.example.qgapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.qgapp.Data.userData;
import com.example.qgapp.login.LoginActivity;
import com.example.qgapp.navigation.GuoYuan.GuoYuanFragment;
import com.example.qgapp.navigation.HomePageFragment.HomePageFragment;
import com.example.qgapp.navigation.NavigationActivity;
import com.example.qgapp.navigation.PersonFragment.PersonFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class  MainActivity extends AppCompatActivity {

    //切换
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int a = 100;
        int b = 200;
        int c = a + b;
        Activity activity = this;
        Thread begin = new Thread() {
            public void run() {
                //显示logo,模拟数据载入
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //判断是否登录
                if (userData.getLoginstate()) {
                    Intent intent_na = new Intent(activity, NavigationActivity.class);
                    startActivity(intent_na);
                } else {
                    Intent intent_login = new Intent(activity, LoginActivity.class);
                    startActivity(intent_login);
                }
            }
        };
        setContentView(R.layout.activity_main);
        begin.start();

        //
//        bottomNavigationView = findViewById(R.id.navigation_bottomTab);
//
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_in_navigation, new HomePageFragment()).commit();
//        }
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                Fragment fragment = null;
//
//                switch (item.getItemId()) {
//                    case R.id.navigation_button_homepage:
//                        fragment = new HomePageFragment();
//                        break;
//                    case R.id.navigation_button_guoyuan:
//                        fragment = new GuoYuanFragment();
//                        break;
//                    case R.id.navigation_button_person:
//                        fragment = new PersonFragment();
//                        break;
//                }
//                getSupportFragmentManager().beginTransaction().replace(R.id.Fragment_in_navigation, fragment).commit();
//                return true;
//            }
//        });


        ActivityDestroy.addDestroyActivityToMap(this, "MainActivity");
    }


}
