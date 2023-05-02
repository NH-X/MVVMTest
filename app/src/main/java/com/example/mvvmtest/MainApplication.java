package com.example.mvvmtest;

import android.app.Application;

public class MainApplication extends Application {
    private static MainApplication myApp;
    private static int index=0;

    @Override
    public void onCreate() {
        super.onCreate();
        myApp=this;
        index=0;
    }

    public static MainApplication getInstance(){
        if(null == myApp){
            myApp=new MainApplication();
        }
        return myApp;
    }

    public int getIndex(){
        return index++;
    }
}
