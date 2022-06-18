package com.example.qgapp.login;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.qgapp.ActivityDestroy;
import com.example.qgapp.R;
import com.example.qgapp.Data.userData;
import com.example.qgapp.navigation.NavigationActivity;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;


public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActivityDestroy.addDestroyActivityToMap(this,"LoginActivity");
        ActivityDestroy.destroyActivity("MainActivity");
        MaterialEditText username = findViewById(R.id.login_edit_username);
        MaterialEditText password = findViewById(R.id.login_edit_password);
        ButtonView post = findViewById(R.id.login_button_post);
        ButtonView register = findViewById(R.id.login_button_register);
        Button resetpassword = findViewById(R.id.login_button_resetpassword);
        //用户条款按钮注册
//监听设置-------------------------------------------------------------------------------------------
        //登录按钮
        post.setOnClickListener(v -> {
            String name =  username.getEditValue();
            String pass =  password.getEditValue();
            createLogindate(name, pass);
            Intent intent_Login_toNa = new Intent(LoginActivity.this, NavigationActivity.class);
            startActivity(intent_Login_toNa);
        });
        //注册按钮
        register.setOnClickListener(v -> {
            FragmentTransaction loginTransaction =
                    getSupportFragmentManager().beginTransaction();
            loginTransaction.add(R.id.fragment_in_login,new RegisterFragment());
            loginTransaction.addToBackStack(null);
            loginTransaction.commit();

        });
        //忘记密码
        resetpassword.setOnClickListener(view -> {
            FragmentTransaction loginTransaction =
                    getSupportFragmentManager().beginTransaction();
            loginTransaction.add(R.id.fragment_in_login,new ReSetPasswordFragment());
            loginTransaction.addToBackStack(null);
            loginTransaction.commit();
        });
        //用户条款
        //---------------//留存


    }









    //保存登录状态
    public void createLogindate(String username,String password){
        userData.updateUsername(username);
        userData.updateUserpass(password);
        userData.updateLoginstate(true);
    }

}
