package com.example.qgapp.Data.GetData;

import com.example.qgapp.Data.UserData.UserData;

import org.jetbrains.annotations.TestOnly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Objects;



//SQL 查询后得到Map，使用Adapter解包
public class DataAdapter {
    public DataAdapter(Map<String, Object> data,String kind){
        switch (kind){          //kind 代表适配的数据表单
            case "UserData" :   //做初始化和登录使用
                UserDataAdapter(data);
                break;

        }
    }




    //UserData的解包方式
    public void UserDataAdapter(Map<String,Object> data) {
        UserData ud = new UserData();
        ud.inputUserID((String) data.get("UserID") );
        ud.inputAccount((String) data.get("Account") );
        ud.inputUserPass((String) data.get("UserPassword") );
        ud.inputEmail((String) data.get("Email") );
        ud.inputPhone((String) data.get("Phone") );
        ud.inputPower((int) data.get("Power") );
    }



}
