package com.example.qgapp.Data.UserData;


public class loginData extends UserData{
    private static boolean loginstate = false;



    public static boolean getLoginstate(){return loginstate;}
    public static void updateLoginstate(boolean value){loginstate = value;}





}

