package com.example.qgapp.Data.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class qgSQL{
    String url = "不可见";
    String name = "不可见";
    String pass = "不可见";
    String SQL;
    qgSQL(String sql){
        SQL = sql;
    }
    public long updateData() {
        long i = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
        }
        try {
            Connection conn = DriverManager.getConnection(url, name, pass);
            Statement statement = conn.createStatement();
            i = statement.executeUpdate(SQL);
            statement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }






}
