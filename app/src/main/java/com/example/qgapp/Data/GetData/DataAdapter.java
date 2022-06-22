package com.example.qgapp.Data.GetData;

import com.example.qgapp.Data.UserData.UserData;

import org.jetbrains.annotations.TestOnly;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Objects;

public class DataAdapter {
    public DataAdapter(Map<String, Object> data,String kind){
        switch (kind){
            case "UserData" :
                UserDataAdapter(data);
                break;
        }
    }

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
