package com.example.qgapp.login;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import com.example.qgapp.date.userdate;
import com.example.qgapp.R;
import com.example.qgapp.navigation.NavigationActivity;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;
import com.example.qgapp.ActivityDestroy;


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

        //登录按钮
        post.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String name =  username.getEditValue();
                String pass =  password.getEditValue();
                createLogindate(name, pass);
                Intent intent_LogintoNa = new Intent(LoginActivity.this, NavigationActivity.class);
                startActivity(intent_LogintoNa);
            }
        });


        //注册按钮
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){
                FragmentTransaction loginTransaction =
                        getSupportFragmentManager().beginTransaction();
                loginTransaction.add(R.id.fragment_in_login,new RegisterFragment());
                loginTransaction.commit();

            }
        });


        //忘记密码
        resetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction loginTransaction =
                        getSupportFragmentManager().beginTransaction();
                loginTransaction.add(R.id.fragment_in_login,new ReSetPasswordFragment());
                loginTransaction.commit();
            }
        });
    }









    //保存登录状态
    public void createLogindate(String username,String password){
        userdate.username = username;
        userdate.userpass = password;
        userdate.loginstate = true;
    }

}
