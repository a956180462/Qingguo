package com.example.qgapp.Data;


public class userData {
    private static boolean loginstate = false;
    private static String  username = "";
    private static String  userpass = "";



    public static boolean getLoginstate(){return loginstate;}
    public static void updateLoginstate(boolean value){loginstate = value;}

    public static String getUsername(){return username;}
    public static void updateUsername(String value){username = value;}

    public static String getUserpass(){return userpass;}
    public static void updateUserpass(String value){userpass = value;}





}

