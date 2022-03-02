package com.example.qgapp.login;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.qgapp.R;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        MaterialEditText username = (MaterialEditText) findViewById(R.id.login_edit_username);
        MaterialEditText password = (MaterialEditText) findViewById(R.id.login_edit_password);
        ButtonView post = (ButtonView) findViewById(R.id.login_button_post);
        ButtonView register = (ButtonView) findViewById(R.id.login_button_register);
        Button resetpassword = (Button) findViewById(R.id.login_button_resetpassword);
        post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name =  username.getEditValue();
                String pass =  password.getEditValue();
                boolean setloginstate = getResources().getBoolean(R.bool.user_loginstate);
                setloginstate = true;
                String setnamedate = getResources().getString(R.string.user_username);
                setnamedate = name;
                String setpassdate = getResources().getString(R.string.user_password);
                setpassdate = pass;
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction loginTransaction =
                        getSupportFragmentManager().beginTransaction();
                loginTransaction.add(R.id.fragment_in_login,new RegisterFragment());
                loginTransaction.commit();

            }
        });
    }


}
