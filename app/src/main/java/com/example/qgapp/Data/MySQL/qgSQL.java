package com.example.qgapp.Data.MySQL;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.qgapp.Data.GetData.DataAdapter;
import com.mysql.jdbc.ResultSetImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qgSQL{
    String url = "jdbc:mysql://www.cnalzsy.top:3306/qg?serverTimezone=UTC";
    String name = "QG";
    String pass = "XGYc245jSajprx5J";
    Connection connection;
    Statement sta;
    static {
        try {
            //load the Driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("驱动！");
        }
    }
    public Map<String, Object> CreateResultSet (String sql) {
        Map<String, Object> Data = new HashMap<>();
        try {
            //create a Connection object
            Connection conn = DriverManager.getConnection(url, name, pass);
            //create a Statement object
            Statement statement = conn.createStatement();
            //Do the action of SQL
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                String a = rs.getString("UserID");
                String b = rs.getString("Account");
                String c = rs.getString("UserPassword");
                String d = rs.getString("Email");
                String e = rs.getString("Phone");
                int f = rs.getInt("Power");
                Data.put("UserID", a);
                Data.put("Account", b);
                Data.put("UserPassword", c);
                Data.put("Email", d);
                Data.put("Phone", e);
                Data.put("Power", f);

            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail");
        }
        System.out.println(Data.get("UserID"));
        return Data;
    }

    public qgSQL(){
        try {
            connection = DriverManager.getConnection(url, name, pass);
            sta = connection.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    public long UpDate(String sql){
        long i = 0;
        try {
            i = sta.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }




}














