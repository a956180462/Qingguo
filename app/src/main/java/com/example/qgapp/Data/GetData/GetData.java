package com.example.qgapp.Data.GetData;

import android.app.Activity;

import com.example.qgapp.Data.MySQL.qgSQL;

import java.io.File;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public class GetData extends qgSQL implements GetDBData,GetFileData{
    Activity activity = null;
    public GetData(){}
    public GetData(Activity a){
        activity = a;
    }
    @Override
    public void loginData_DB(String key,String pass) {
        String sql = "SELECT * FROM USER_DATA WHERE UserID =" + "'"+ key +"'"+
                "OR Account =" + "'"+ key +"'"+
                "OR Phone =" + "'"+ key +"'"+
                "AND UserPassword =" + "'"+ pass +"'";
        Map<String,Object> data = new qgSQL().CreateResultSet(sql);
        if(!data.isEmpty()){
            new DataAdapter(data,"UserData");
        }
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
