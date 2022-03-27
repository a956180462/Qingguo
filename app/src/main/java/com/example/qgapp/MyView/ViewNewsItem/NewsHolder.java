package com.example.qgapp.MyView.ViewNewsItem;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.qgapp.R;
import com.xuexiang.xui.adapter.recyclerview.RecyclerViewHolder;

class NewsHolder extends RecyclerViewHolder {
    TextView title;
    TextView content;
    ImageView img;
    public NewsHolder(View itemView) {
        super(itemView);
        title = findViewById(R.id.news_title);
        content = findViewById(R.id.news_content);
        img = findViewById(R.id.news_img);

    }
}
