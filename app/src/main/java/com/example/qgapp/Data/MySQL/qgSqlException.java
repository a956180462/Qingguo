package com.example.qgapp.Data.MySQL;

public class qgSqlException extends Exception{
    String Massage;
    public qgSqlException(String massage){Massage = massage;}
    public String getMass(){return Massage;}
    public void printMass(){System.out.println(Massage);}
    public void DriverException(){}
    public void ConnException(){}
    public void CloseException(){}

}
