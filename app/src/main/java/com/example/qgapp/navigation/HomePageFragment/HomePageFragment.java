package com.example.qgapp.navigation.HomePageFragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.qgapp.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HomePageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_homepage,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();

        Activity g = getActivity();
        List<Fragment> list = new ArrayList<>();
        Fragment Qiye = new fragQiye(g);
        Fragment Zhengfu = new fragZhengfu(g);
        TabLayout tabLayout = Objects.requireNonNull(g).findViewById(R.id.homepage_Tab);
        list.add(Qiye);
        list.add(Zhengfu);
        ViewPager homeViewPager = Objects.requireNonNull(g).findViewById(R.id.homepage_Viewpager);
        FragViewPagerAdapter adapter = new FragViewPagerAdapter(getParentFragmentManager(), list);
        homeViewPager.setAdapter(adapter);
        homeViewPager.setTag(tabLayout);
    }
}
