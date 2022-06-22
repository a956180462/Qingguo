package com.example.qgapp.Data.UserData;

import java.util.List;

public class UserData {
    public static String username = "";
    public static String password = "";
    public static String userID = "";
    public List<String> list;
    public UserData(){
        list.add(username);
        list.add(password);
        list.add(userID);
    }
    public void inputUserName(String name){
        username = name;
    }
    public void inputUserPass(String pass){
        password = pass;
    }
    public void inputUserID(String ID){
        userID = ID;
    }

}
