package com.farzin.metro.Utils;

import android.content.Context;
import android.content.SharedPreferences;

public class AppConfig {

    SharedPreferences sh;
    SharedPreferences.Editor editor;

    public AppConfig(Context context) {

        sh = context.getSharedPreferences("Setting" , Context.MODE_PRIVATE);
        editor = sh.edit();

    }

    public void setTitle(String title){

        editor.putString("title",title);
        editor.commit();
    }

    public String getTitle(){
        return sh.getString("title","");
    }

    public void setEnglishTitle(String enTitle){
        editor.putString("englishTitle",enTitle);
        editor.commit();
    }

    public String getEnglishTitle(){
        return sh.getString("englishTitle","");
    }

    public void setLineID(int lineID){
        editor.putInt("lineId",lineID);
        editor.commit();
    }

    public int getLineID(){
        return sh.getInt("lineId",0);
    }
}
