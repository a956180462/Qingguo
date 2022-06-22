package com.example.qgapp.Data.GetData;

import com.example.qgapp.Data.MySQL.qgSqlException;

import java.sql.ResultSet;
import java.sql.Statement;

public interface GetDBData {
    /*


     */
    ResultSet loginData_DB(String UserID);
    ResultSet userData_DB();
    ResultSet newsData_DB();

}
