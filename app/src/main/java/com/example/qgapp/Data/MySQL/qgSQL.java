package com.example.qgapp.Data.MySQL;

import androidx.annotation.NonNull;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class qgSQL{
    static String url = "jdbc:mysql://www.cnalzsy.top:3306/qg";
    static String name = "QG";
    static String pass = "XGYc245jSajprx5J";
    public static Connection connection;
    public static Statement statement;
    static {
        //Create a Connection object
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            new qgSqlException("DriverException").DriverException();
        }
        try {
            connection = DriverManager.getConnection(url, name, pass);
            statement = connection.createStatement();
        } catch (SQLException e) {
            new qgSqlException(e.getMessage()).ConnException();
        }
    }

    public void CloseConn() {
        try {
            connection.close();
        } catch (SQLException e) {
            new qgSqlException(e.getMessage()).CloseException();
        }
    }




}
