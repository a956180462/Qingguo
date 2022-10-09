package com.example.qgapp.Data.GetData;

import com.example.qgapp.Data.MySQL.qgSqlException;

import java.sql.ResultSet;
import java.sql.Statement;

public interface  GetDBData {
    /*


     */
    void loginData_DB(String UserKey,String pass);
    ResultSet userData_DB();
    ResultSet newsData_DB();

}
