package com.example.qgapp.navigation;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qgapp.MyView.ViewNewsItem;
import com.example.qgapp.R;
import com.example.qgapp.date.getDate;

import java.util.List;
import java.util.Objects;

public class HomePageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_homepage,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Activity g = getActivity();
        RecyclerView recyclerView = Objects.requireNonNull(g).findViewById(R.id.homepage_NewsShow);
        List<ViewNewsItem.NewsItem> n_list = getDate.getNewsDate();
        ViewNewsItem.NewsAdapter n_Adapter = new ViewNewsItem.NewsAdapter(g,n_list);
        recyclerView.setAdapter(n_Adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(g);
        recyclerView.setLayoutManager(layoutManager);
    }
}
