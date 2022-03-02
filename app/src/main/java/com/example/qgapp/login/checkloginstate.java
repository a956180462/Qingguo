package com.example.qgapp.login;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class checkloginstate extends AppCompatActivity {


    public boolean getloginstate() {
        File userloginstate = new File("userloginstate");
        if(!userloginstate.exists()){
            return false;
        }
        return true;

    }
}
