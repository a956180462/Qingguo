package com.example.qgapp.navigation;

import android.os.Bundle;
import android.widget.Button;


import com.example.qgapp.ActivityDestroy;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.qgapp.R;
import com.example.qgapp.navigation.GuoYuan.GuoYuanFragment;
import com.example.qgapp.navigation.HomePageFragment.HomePageFragment;
import com.example.qgapp.navigation.PersonFragment.PersonFragment;


public class NavigationActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ActivityDestroy.destroyActivity("MainActivity");
        ActivityDestroy.destroyActivity("LoginActivity");
    //----------------------------------------------------------------------
        Button homepage = findViewById(R.id.navigation_button_homepage);
        Button guoyuan = findViewById(R.id.navigation_button_guoyuan);
        Button personal = findViewById(R.id.navigation_button_person);

    //----------------------------------------------------------------------
        FragmentTransaction naviTransaction =
                getSupportFragmentManager().beginTransaction();
        naviTransaction.add(R.id.Fragment_in_navigation,new HomePageFragment());
        naviTransaction.commit();

        homepage.setOnClickListener(v -> {
            naviTransaction.add(R.id.Fragment_in_navigation,new HomePageFragment());
            //naviTransaction.commitAllowingStateLoss();
        });

        guoyuan.setOnClickListener(v -> {
            naviTransaction.add(R.id.Fragment_in_navigation,new GuoYuanFragment());
            //naviTransaction.commit();
        });

        personal.setOnClickListener(v -> {
            naviTransaction.add(R.id.Fragment_in_navigation,new PersonFragment());
            //naviTransaction.commit();
        });


    }


}
