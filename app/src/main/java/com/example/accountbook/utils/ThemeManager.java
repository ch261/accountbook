package com.example.accountbook.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.example.accountbook.R;
import com.example.accountbook.common.Constants;


public class ThemeManager {

    private String[] mThemes = {"绿", "黑", "红", "蓝", "紫", "橙", "棕"};

    private static ThemeManager instance;

    public static ThemeManager getInstance() {
        if (instance == null) {
            instance = new ThemeManager();
        }
        return instance;
    }

    public String[] getThemes(){
        return mThemes;
    }


    public void setTheme(Activity context, String theme){
        String curTheme = SharedPUtils.getCurrentTheme(context);
        if(curTheme != null && curTheme.equals(theme)){
            return;
        }

        SharedPUtils.setCurrentTheme(context,theme);

        context.finish();
        Intent intent = context.getIntent();
        intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.putExtra(Constants.EXTRA_IS_UPDATE_THEME, true);
        context.startActivity(intent);
    }


    public String getCurThemeName(Context context){
        return SharedPUtils.getCurrentTheme(context);
    }



    public void init(Context context) {
        String theme = SharedPUtils.getCurrentTheme(context);
        if(theme.equals(mThemes[0])){
            context.setTheme(R.style.AppTheme);
        }else if(theme.equals(mThemes[1])){
            context.setTheme(R.style.AppTheme_Black);
        }else if(theme.equals(mThemes[2])){
            context.setTheme(R.style.AppTheme_Green);
        }else if(theme.equals(mThemes[3])){
            context.setTheme(R.style.AppTheme_Blue);
        }else if(theme.equals(mThemes[4])){
            context.setTheme(R.style.AppTheme_Purple);
        }else if(theme.equals(mThemes[5])){
            context.setTheme(R.style.AppTheme_Orange);
        }else if(theme.equals(mThemes[6])){
            context.setTheme(R.style.AppTheme_Brown);
        }
    }
}

