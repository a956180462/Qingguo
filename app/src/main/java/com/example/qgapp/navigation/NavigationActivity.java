package com.example.qgapp.navigation;

import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.qgapp.ActivityDestroy;
import com.example.qgapp.Data.MySQL.qgSQL;
import com.example.qgapp.R;
import com.example.qgapp.navigation.GuoYuan.GuoYuanFragment;
import com.example.qgapp.navigation.HomePageFragment.HomePageFragment;
import com.example.qgapp.navigation.PersonFragment.PersonFragment;


public class NavigationActivity extends AppCompatActivity {
    int state = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
    //----------------------------------------------------------------------
        Button homepage = findViewById(R.id.navigation_button_homepage);
        Button guoyuan = findViewById(R.id.navigation_button_guoyuan);
        Button personal = findViewById(R.id.navigation_button_person);

    //----------------------------------------------------------------------

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction naviTransaction = fragmentManager.beginTransaction();
        naviTransaction.add(R.id.Fragment_in_navigation,new HomePageFragment());
        naviTransaction.setReorderingAllowed(true);
        naviTransaction.commit();

        homepage.setOnClickListener(v -> {
            if(state != 0) {
                FragmentTransaction ft1 = fragmentManager.beginTransaction();
                ft1.replace(R.id.Fragment_in_navigation, HomePageFragment.class, null);
                ft1.commit();
                state = 0;
            }

        });

        guoyuan.setOnClickListener(v -> {
            if(state != 1) {
                FragmentTransaction ft2 = fragmentManager.beginTransaction();
                ft2.replace(R.id.Fragment_in_navigation, GuoYuanFragment.class, null);
                ft2.commit();
                state = 1;
            }
        });

        personal.setOnClickListener(v -> {
            if(state != 2) {
                FragmentTransaction ft3 = fragmentManager.beginTransaction();
                ft3.replace(R.id.Fragment_in_navigation,PersonFragment.class,null);
                ft3.commit();
                state = 2;
            }
        });




    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //APP Destroy,close the SQL connection
        //new qgSQL().CloseConn();
    }
}
