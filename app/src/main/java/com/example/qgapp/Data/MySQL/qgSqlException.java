package com.example.qgapp.Data.MySQL;

import android.app.Activity;
import android.widget.Toast;

public class qgSqlException extends Exception{
    String Massage;
    public qgSqlException(String massage){Massage = massage;}
    public String getMass(){return Massage;}
    public void printMass(){System.out.println(Massage);}
    public void DriverException(){}
    public void ConnException(){}
    public void CloseException(){}
    public void UserNOTExist(Activity activity){
        Toast.makeText(activity,"用户不存在",Toast.LENGTH_LONG).show();
    }


}
