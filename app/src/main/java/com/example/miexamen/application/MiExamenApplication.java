package com.example.miexamen.application;

import android.app.Application;
import android.content.Context;

import androidx.appcompat.app.AppCompatDelegate;

public class MiExamenApplication extends Application {
    private static MiExamenApplication instance;
    private static Context appContext;

    public static MiExamenApplication getInstance(){return instance;}
    public static Context getAppContext(){return appContext;}

    public void setAppContext(Context mAppContext){this.appContext=mAppContext;}

    @Override
    public void onCreate(){
        super.onCreate();
        instance = this;

        this.setAppContext(getApplicationContext());

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
