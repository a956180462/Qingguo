package com.example.qgapp.date;

import com.example.qgapp.MyView.ViewNewsItem;

import java.util.ArrayList;
import java.util.List;

public class getDate {
    //获取NewsItem的数据，以后请重写该方法
    public static List<ViewNewsItem.NewsItem> getNewsDate(){
        int i = 0;
        List<ViewNewsItem.NewsItem> newsList = new ArrayList<>();
        for (;i<10;i++){
            ViewNewsItem.NewsItem news = new ViewNewsItem.NewsItem();
            news.title = "title" + (i+1);
            news.content = "content" + (i+1);
            newsList.add(news);
        }
        return newsList;
    }

}
