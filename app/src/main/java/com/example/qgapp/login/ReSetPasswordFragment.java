package com.example.qgapp.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.qgapp.R;
import com.example.qgapp.date.userdate;
import com.xuexiang.xui.widget.button.ButtonView;
import com.xuexiang.xui.widget.edittext.materialedittext.MaterialEditText;

public class ReSetPasswordFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_resetpassword, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        //获取activity
        FragmentActivity g = requireActivity();
        //获取title
        ConstraintLayout title = g.findViewById(R.id.resetpassword_title);
//------注册控件----------------------------------------------------------------------
        TextView titleText = title.findViewById(R.id.Title_Text);
        Button titleBack = title.findViewById(R.id.Title_button_back);
        Button getphonephrase = g.findViewById(R.id.resetpassword_button_getphonephrase);
        ButtonView post = g.findViewById(R.id.resetpassword_button_post);
        MaterialEditText username = g.findViewById(R.id.resetpassword_edit_username);
        MaterialEditText password = g.findViewById(R.id.resetpassword_edit_password);
        MaterialEditText phone    = g.findViewById(R.id.resetpassword_edit_phone);
        MaterialEditText phonephrase = g.findViewById(R.id.resetpassword_edit_phonephrase);
//------设置控件-------------------------------------------------------------------------------------
        titleText.setText("修改密码");
        //标题栏返回键
        titleBack.setOnClickListener(view -> g.onBackPressed());
        //获取验证码,现在为空
        getphonephrase.setOnClickListener(view -> {

        });
        //点击post按钮
        post.setOnClickListener(view -> {
                String name =  username.getEditValue();
                String pass =  password.getEditValue();
                String ph =    phone.getEditValue();
                String phph =  phonephrase.getEditValue();
                sendResetPasswordDate(name,pass,ph,phph);
                Toast.makeText(getActivity(),"修改成功",Toast.LENGTH_LONG).show();
                g.onBackPressed();
        });




    }

    private void sendResetPasswordDate(String name, String pass, String ph, String phph) {
        userdate.setResetPasswordDate(name,pass,ph,phph);
    }
}
