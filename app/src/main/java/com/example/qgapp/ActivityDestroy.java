package com.example.qgapp;


import android.app.Activity;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

//为了管理activity窗口
//只作用于UI线程

public class ActivityDestroy {

    private static final Map<String, Activity> destroyMap = new HashMap<>();

    //将Activity添加到队列中
    public static void addDestroyActivityToMap(Activity activity, String activityName) {
        destroyMap.put(activityName, activity);
    }

    //根据名字销毁制定Activity
    public static void destroyActivity(String activityName) {
        Set<String> keySet = destroyMap.keySet();
        if (keySet.size() > 0) {
            for (String key : keySet) {
                if (activityName.equals(key)) {
                    Objects.requireNonNull(destroyMap.get(key)).finish();
                }
            }
        }
    }

}


