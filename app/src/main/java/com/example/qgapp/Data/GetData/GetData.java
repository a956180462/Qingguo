package com.example.qgapp.Data.GetData;

import android.app.Activity;

import com.example.qgapp.Data.MySQL.qgSQL;
import com.example.qgapp.Data.MySQL.qgSqlException;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class GetData extends qgSQL implements GetDBData,GetFileData{
    Activity activity = null;
    public GetData(){}
    public GetData(Activity a){
        activity = a;
    }
    @Override
    public ResultSet loginData_DB(String key,String pass) {
        String sql = "SELECT * FROM USER_DATA WHERE UserID =" + "'"+ key +"'"+
                "OR Account =" + "'"+ key +"'"+
                "OR Account =" + "'"+ key +"'"+
                "AND UserPassword =" + "'"+ pass +"'";
        ResultSet res = null;
        try {
            res = statement.executeQuery(sql);
        } catch (SQLException e) {
            new qgSqlException("loginData_DB Exception").UserNOTExist(activity);
        }
        return res;
    }

    @Override
    public List<String> loginData_File(){
        List<String> list = null;
        File file = new File("\\\\Login.qg");

        return list;
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
