package com.example.qgapp.date;


public class userdate {
    public static boolean loginstate = false;
    public static String  username = "";
    public static String  userpass = "";


    //用户注册信息
    static class Registerdate{
        static String username ;
        static String password ;
        static String phone ;
        static String phonephrase ;
    }
    public static void setRegisterdate(String name, String pass, String ph, String phph){
        Registerdate.username = name; Registerdate.password = pass;
        Registerdate.phone = ph; Registerdate.phonephrase = phph;
    }


    static class ResetPasswordDate{
        static String username ;
        static String password ;
        static String phone ;
        static String phonephrase ;
    }
    public static void setResetPasswordDate(String name, String pass, String ph, String phph) {
        ResetPasswordDate.username = name; ResetPasswordDate.password = pass;
        ResetPasswordDate.phone = ph; ResetPasswordDate.phonephrase = phph;
    }

}

