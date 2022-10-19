package com.example.qgapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.qgapp.Common.OnBoarding;
import com.example.qgapp.Data.GetData.GetData;
import com.example.qgapp.Data.UserData.LoginData;
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
                //加载SQL驱动
                try{
                    Class.forName("com.example.qgapp.Data.MySQL.qgSQL");
                } catch (ClassNotFoundException e) {
                    System.out.println("路径错了");
                }
                //尝试从文件获取登录信息
                new GetData(activity).loginData_File();
                System.out.println("zhengc2");
                //判断是否登录
                if(false){
                    Intent intent_na = new Intent(activity, NavigationActivity.class);
                    startActivity(intent_na);

                }else {
                    Intent intent_login = new Intent(activity, OnBoarding.class);
                    startActivity(intent_login);

                }
                activity.finish();
            }
        };
//        Thread Sql = new Thread() {
//            @Override
//            public void run() {
//                super.run();
//                new GetData().loginData_DB("2013020220","cna123456789");
//
//            }
//        };
        setContentView(R.layout.activity_main);
        begin.start();
        //Sql.start();

    }

}

