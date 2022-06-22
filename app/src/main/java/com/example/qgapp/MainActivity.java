package com.example.qgapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qgapp.Common.OnBoarding;
import com.example.qgapp.Data.GetData.GetData;
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
        Thread Sql = new Thread() {
            @Override
            public void run() {
                super.run();
                new GetData().loginData_DB("2013020220","cna123456789");

            }
        };
        setContentView(R.layout.activity_main);
        begin.start();
        Sql.start();

    }

}

