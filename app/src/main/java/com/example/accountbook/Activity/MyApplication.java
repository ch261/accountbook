package com.example.accountbook.Activity;

import android.app.Application;
import android.content.Context;

import com.example.accountbook.bean.MyUser;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;


public class MyApplication extends Application {

    public static MyApplication application;
    private static Context context;
    private static MyUser currentUser;




    public static String getCurrentUserId() {
        currentUser = BmobUser.getCurrentUser(MyUser.class);
        if (currentUser == null)
            return null;
        return BmobUser.getCurrentUser(MyUser.class).getObjectId();
    }

    public static Context getContext() {
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;

        Bmob.initialize(this, "40f0c2fca73b78754c28cb41a16ae360");
        context = getApplicationContext();
        currentUser = BmobUser.getCurrentUser(MyUser.class);
    }






}
