package com.example.qgapp.Data.UserData;

import java.util.List;

public class UserData {
    private static String UserID = "";
    private static String Account = "";
    private static String Password = "";
    private static String Email = "";
    private static String Phone = "";
    private static int Power = 0;



    public void inputUserID(String ID){ UserID = ID; }
    public void inputAccount(String acc){ Account = acc; }
    public void inputUserPass(String pass){ Password = pass; }
    public void inputEmail(String email){ Email = email; }
    public void inputPhone(String phone){ Phone = phone; }
    public void inputPower(int power){ Power = power; }
    public String showUserID() {return UserID;}
    public String showAccount() {return Account;}
    public String showUserPass() {return Password;}
    public String showEmail() {return Email;}
    public String showPhone() {return Phone;}
    public int showPower() {return Power;}

}
