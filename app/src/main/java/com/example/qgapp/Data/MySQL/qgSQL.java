package com.example.qgapp.Data.MySQL;

import static android.content.ContentValues.TAG;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.qgapp.Data.GetData.DataAdapter;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class qgSQL{
    static final String url = "jdbc:mysql://qg.ajohn.top:3306/qg?serverTimezone=UTC";
    static final String name = "qg";
    static final String pass = "jS2ZGHWYrDHwYekf";

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
    //创建结果数据表
    //返回：Map<String 属性，Object 值>；参数（String SQL语句）
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
                String name = rs.getString("NAME");
                System.out.println(name);
                String pass = rs.getString("PASSWORD");
                int id = rs.getInt("ID");
                int phone = rs.getInt("PHONE");
                Data.put("Name", name);
                Data.put("UserPassword", pass);
                Data.put("UserID", id);
                Data.put("Phone", phone);
            }
            rs.close();
            statement.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fail");
        }
        System.out.println(Data.get("ID"));
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














