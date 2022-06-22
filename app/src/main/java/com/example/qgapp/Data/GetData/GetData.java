package com.example.qgapp.Data.GetData;

import android.app.Activity;

import com.example.qgapp.Data.MySQL.qgSQL;
import com.example.qgapp.Data.MySQL.qgSqlException;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetData extends qgSQL implements GetDBData,GetFileData{
    Activity activity = null;
    public GetData(){}
    public GetData(Activity a){
        activity = a;
    }
    @Override
    public ResultSet loginData_DB(String key) {
        String sql = "SELECT * FROM USER_DATA WHERE UserID =" + "'"+ key +"'";
        ResultSet res = null;
        try {
            res = statement.executeQuery(sql);
        } catch (SQLException e) {
            new qgSqlException("loginData_DB Exception").UserNOTExist(activity);
        }
        return res;
    }
    public File loginData_File(){
        File file = new File("\\\\Login.qg");

        return file;
    }

    @Override
    public ResultSet userData_DB() {
        return null;
    }

    @Override
    public ResultSet newsData_DB() {
        return null;
    }
}
