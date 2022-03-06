package com.example.qgapp.MyView;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qgapp.R;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;

import java.util.List;


//ViewNewsItem的全部方法

public class ViewNewsItem{
    //NewsItem的数据结构，图片后续添加
    public static class NewsItem {
        public String title;
        public String content;
        //public int img;
    }
    //NewsItem的适配器，需要获取目的activity
    public static class NewsAdapter extends RecyclerView.Adapter<NewsHolder>{
        Activity activity ;
        List<NewsItem> newsItemList;
        public NewsAdapter(Activity act, List<NewsItem> newsList){
            activity = act;
            newsItemList = newsList;
        }
        @NonNull
        @Override
        public NewsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = View.inflate(activity,R.layout.view_news_item,null);
            NewsHolder newsHolder = new NewsHolder(view);
            return newsHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull NewsHolder holder, int position) {
            NewsItem newsItem = newsItemList.get(position);
            holder.title.setText(newsItem.title);
            holder.content.setText(newsItem.content);
        }

        @Override
        public int getItemCount() {
            return newsItemList.size();
        }
    }
    //内部私有类，写明了NewItem的holder，不能被外部调用
    private static class NewsHolder extends RecyclerViewHolder{
        TextView title;
        TextView content;
        //ImageView img;
        public NewsHolder(View itemView) {
            super(itemView);
            title = findViewById(R.id.news_title);
            content = findViewById(R.id.news_content);
            //img = findViewById(R.id.news_img);

        }
    }

}
