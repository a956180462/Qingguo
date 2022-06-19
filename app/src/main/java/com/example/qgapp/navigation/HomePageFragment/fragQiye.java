package com.example.qgapp.navigation.HomePageFragment;

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

import com.example.qgapp.MyView.ViewNewsItem.NewsAdapter;
import com.example.qgapp.R;
import com.example.qgapp.Data.GetData_lakua;

public class fragQiye extends Fragment {
    Activity activity;
    fragQiye(Activity activity){this.activity = activity;}
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.frag_home_qiye,container,false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = new Bundle();
        args.putString("part","news");
        args.putString("head","企业");
        GetData_lakua getDataLakua = new GetData_lakua(args);
        RecyclerView recyclerView = activity.findViewById(R.id.Frag_home_qiye_Recycler);
        NewsAdapter newsAdapter = new NewsAdapter(activity, getDataLakua.getNewsDate());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(newsAdapter);
    }
}
