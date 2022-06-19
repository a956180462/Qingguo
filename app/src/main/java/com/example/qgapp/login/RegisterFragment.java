package com.example.qgapp.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.qgapp.Data.loginData;
import com.example.qgapp.R;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;

public class RegisterFragment extends Fragment {
    //初始化用户协议未同意
    private static boolean agreestate = false;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
      return inflater.inflate(R.layout.fragment_register, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //获取activity
        FragmentActivity g = requireActivity();
        //获取title
        ConstraintLayout title = g.findViewById(R.id.register_title);
//------获取控件-------------------------------------------------------------------------------------
        TextView titleText = title.findViewById(R.id.Title_Text);
        Button titleBack = title.findViewById(R.id.Title_button_back);
        RadioButton agree = g.findViewById(R.id.register_button_agree);
        Button getphonephrase = g.findViewById(R.id.register_button_getphonephrase);
        ButtonView register = g.findViewById(R.id.register_button_register);
        Button agreement = g.findViewById(R.id.register_button_agreement);
        MaterialEditText username = g.findViewById(R.id.register_edit_username);
        MaterialEditText password = g.findViewById(R.id.register_edit_password);
        MaterialEditText phone    = g.findViewById(R.id.register_edit_phone);
        MaterialEditText phonephrase = g.findViewById(R.id.register_edit_phonephrase);
//------设置控件-------------------------------------------------------------------------------------
        titleText.setText("注册账户");
        //是否点击agree
        agree.setOnClickListener(view -> {
            agreestate = (!agreestate);
            agree.setChecked(agreestate);
        });
        //点击注册按钮
        register.setOnClickListener(view -> {
            if(agreestate){
                String name =  username.getEditValue();
                String pass =  password.getEditValue();
                String ph =    phone.getEditValue();
                String phph =  phonephrase.getEditValue();
                Toast.makeText(getActivity(),"注册成功",Toast.LENGTH_LONG).show();
                agreestate = false;
                g.onBackPressed();
            }else {
                Toast.makeText(getActivity(),"请阅读并同意用户条款",Toast.LENGTH_LONG).show();
            }

        });
        //标题栏返回键
        titleBack.setOnClickListener(view -> g.onBackPressed());
        //获取验证码,现在为空
        getphonephrase.setOnClickListener(view -> {

        });
        //用户条款,现在为空
        agreement.setOnClickListener(view -> {

        });



    }
    private void postRegisterData(String name,String pass,String ph,String phph){
        loginData.updateUsername(name);
        loginData.updateUserpass(pass);
    }

}
