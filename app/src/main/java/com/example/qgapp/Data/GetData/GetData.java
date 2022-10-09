package com.example.qgapp.Data.GetData;

import android.app.Activity;
import android.content.Context;
import android.util.Xml;

import com.example.qgapp.Data.MySQL.qgSQL;
import com.example.qgapp.Data.UserData.LoginData;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
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
    public void loginData_File(){
        LoginData loginData = new LoginData();
        File file = new File(activity.getFilesDir().getAbsolutePath(),"LoginData.xml");
        if(file.exists()){
            try {
                FileInputStream fis = new FileInputStream(file);
                XmlPullParser xp = Xml.newPullParser();
                xp.setInput(fis,"utf-8");

                int type = xp.getEventType();

                while (type!=XmlPullParser.END_DOCUMENT){
                    switch (type){
                        case  XmlPullParser.START_TAG:
                            if("student".equals(xp.getName())){//获取当前标签的名字
                            }else if("UserID".equals(xp.getName())){
                                String ID = xp.nextText();//获取当前节点的下一个节点的文本，并把指针移动至当前节点的结束节点
                                loginData.inputUserID(ID);
                            }else if("Account".equals(xp.getName())){
                                String Account = xp.nextText();
                                loginData.inputAccount(Account);
                            }else if("UserPassword".equals(xp.getName())){
                                String pass = xp.nextText();
                                loginData.inputUserPass(pass);
                            }else if("Email".equals(xp.getName())){
                                String Email = xp.nextText();
                                loginData.inputEmail(Email);
                            }else if("Phone".equals(xp.getName())){
                                String Phone = xp.nextText();
                                loginData.inputPhone(Phone);
                            }else if("Power".equals(xp.getName())){
                                String power = xp.nextText();
                                loginData.inputPower(new Integer(power));
                            }
                            break;
                        case XmlPullParser.END_TAG:
                            break;
                    }
                    type = xp.next();
                }
                System.out.println("zhengchang1");
                fis.close();
            } catch (XmlPullParserException e) {
                e.printStackTrace();
                System.out.println("zaizheli1");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("zaizheli2");
            }
            LoginData.updateLoginstate(true);
        }
        else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("zaizheli3");
            }
            LoginData.updateLoginstate(false);
        }

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
