package com.example.weather;

import android.app.Application;
import android.content.Context;

import java.util.List;

import database.Sum;

public class SunnyWeatherApplication extends Application {

    public static Context context;
    public static final String TOKEN = "1bbbb4d603ae4affa79d4e5824b837d4";
    public static Sum summm1;
    public static List<Sum> summm2;
    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
