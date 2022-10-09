package com.example.qgapp.Data.UserData;

//继承自UserData，包含用户数据，可以使用UserData的所有函数
public class LoginData extends UserData{
    private static boolean loginstate = false;
    public static boolean getLoginstate(){return loginstate;}
    public static void updateLoginstate(boolean value){loginstate = value;}
}

