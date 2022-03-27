package com.example.qgapp.MyView.ViewNewsItem;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qgapp.R;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder>{
    Activity activity ;
    List<NewsItem> newsItemList;
    public NewsAdapter(Activity act, List<NewsItem> newsList){
        activity = act;
        newsItemList = newsList;
    }
    @NonNull
    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(activity, R.layout.view_news_item,null);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
        NewsItem newsItem = newsItemList.get(position);
        holder.title.setText(newsItem.title);
        holder.content.setText(newsItem.content);
        holder.img.setImageResource(R.drawable.example_news_image);
    }

    @Override
    public int getItemCount() {
        return newsItemList.size();
    }
}
