package com.example.qgapp.Data.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class qgSQL{
    String url = "jdbc:mysql://www.cnalzsy.top:3306/qg";
    String name = "QG";
    String pass = "XGYc245jSajprx5J";
    String SQL;
    qgSQL(String sql){
        SQL = sql;
    }
    public long updateData() throws qgSqlException {
        long i = 0;
        int error = 1;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            error = 0;
        }
        try {
            Connection conn = DriverManager.getConnection(url, name, pass);
            Statement statement = conn.createStatement();
            i = statement.executeUpdate(SQL);
            statement.close();
            conn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            error = -1;
        }
        return i;
    }






}
