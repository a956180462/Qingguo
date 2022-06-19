package com.example.qgapp.Data;

import android.os.Bundle;
import java.lang.String;
import com.example.qgapp.MyView.ViewNewsItem.NewsItem;
import java.util.ArrayList;
import java.util.List;

public class GetData_lakua {
    String head;
    public GetData_lakua(Bundle args){
        head = args.getString("head");
    }

    //获取NewsItem的数据，以后请重写该方法
    public List<NewsItem> getNewsDate(){
        int i = 0;
        List<NewsItem> newsList = new ArrayList<>();
        for (;i<10;i++){
            NewsItem news = new NewsItem();
            news.title = "title" + (head+(i+1));
            news.content = "content" + (i+1);
            newsList.add(news);
        }
        return newsList;
    }

}
