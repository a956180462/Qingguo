package com.example.qgapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qgapp.Common.OnBoarding;
import com.example.qgapp.Data.UserData.loginData;
import com.example.qgapp.navigation.NavigationActivity;


public class  MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity activity = this;
        Thread begin = new Thread(){
            public void run(){
                //显示logo,模拟数据载入
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try{
                    Class.forName("com.example.qgapp.Data.MySQL.qgSQL");
                } catch (ClassNotFoundException e) {
                    System.out.println("fail");
                }
                //判断是否登录
                if(loginData.getLoginstate()){
                    Intent intent_na = new Intent(activity, NavigationActivity.class);
                    startActivity(intent_na);

                }else {
                    Intent intent_login = new Intent(activity, OnBoarding.class);
                    startActivity(intent_login);

                }
                activity.finish();
            }
        };
        setContentView(R.layout.activity_main);
        begin.start();


    }

}

