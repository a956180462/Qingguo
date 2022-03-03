package com.example.qgapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;

import com.example.qgapp.login.LoginActivity;
import com.example.qgapp.login.checkloginstate;
import com.example.qgapp.navigation.NavigationActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //判断是否登录

        checkloginstate check = new checkloginstate();
        if(check.check()){
            Intent intent_na = new Intent(this, NavigationActivity.class);
            startActivity(intent_na);
        }else {
            Intent intent_login = new Intent(this, LoginActivity.class);
            startActivity(intent_login);
        }
        ActivityDestroy.addDestroyActivityToMap(this,"MainActivity");
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}
