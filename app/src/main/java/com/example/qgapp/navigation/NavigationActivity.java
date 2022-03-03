package com.example.qgapp.navigation;

import android.os.Bundle;
import com.example.qgapp.ActivityDestroy;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.qgapp.R;

public class NavigationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        ActivityDestroy.destroyActivity("MainActivity");
        ActivityDestroy.destroyActivity("LoginActivity");

    }
}
